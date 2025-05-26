package com.atomic.catalogo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.repository.CarroRepository;
import com.atomic.catalogo.repository.MarcaRepository;
import com.atomic.catalogo.repository.MotorRepository;
import com.atomic.catalogo.service.exception.ObjectNotFoundException;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MotorRepository motorRepository;

    @Transactional(readOnly = true)
    public List<CarroDTO> getAll() {
        List<Carro> carros = carroRepository.findAll();

        // Inicializar relações lazy
        carros.forEach(carro -> {
            Hibernate.initialize(carro.getMarca());
            Hibernate.initialize(carro.getMotor());
        });

        return carros.stream()
                .map(carro -> CarroDTO.fromCarro(carro, carro.getMarca().getNome(), carro.getMotor().getId().toString()))
                .collect(Collectors.toList());
    }

    @Transactional
    public CarroDTO register(CarroDTO obj) {
        motorRepository.findById(UUID.fromString(obj.motor())).orElseThrow(
                () -> new ObjectNotFoundException("O Motor especificado não foi encontrado em nossa base"));

        marcaRepository.findByNomeIgnoreCase(obj.marca()).orElseThrow(
                () -> new ObjectNotFoundException("A Marca especificada não foi encontrada em nossa base"));

        Carro carro = Carro.fromDTO(obj);
        carroRepository.save(carro); // Substituído saveAndFlush por save
        return obj;
    }

    public void delete(UUID id) {
        Carro obj = carroRepository.findById(id).orElse(null);
        if (obj == null) {
            throw new ObjectNotFoundException("Carro não encontrado");
        } else {
            carroRepository.delete(obj);
        }
    }

    @Transactional(readOnly = true)
    public CarroDTO getById(UUID id) {
        Carro obj = carroRepository.findByIdWithAssociations(id)
                .orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));

        // Garantir que as relações lazy estão inicializadas
        Hibernate.initialize(obj.getMarca());
        Hibernate.initialize(obj.getMotor());

        return CarroDTO.fromCarro(obj,obj.getMarca().getNome(), obj.getMotor().getId().toString());
    }

    @Transactional
    public CarroDTO update(CarroDTO carro, UUID id) {
        Carro obj = carroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
        carroRepository.save(obj); // Substituído saveAndFlush por save
        return CarroDTO.fromCarro(obj,obj.getMarca().getNome(), obj.getMotor().getId().toString());
    }
}
