package com.atomic.catalogo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.entity.Motor;
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

	public List<CarroDTO> getAll() {
		List<Carro> carros = carroRepository.findAll();
		List<CarroDTO> carrosDTO = carros.stream().map(carro -> CarroDTO.fromCarro(carro)).collect(Collectors.toList());
		return carrosDTO;
	}

	@Transactional
	public Carro register(CarroDTO carroDTO) {
		Motor motor = motorRepository.findById(UUID.fromString(carroDTO.motor())).orElseThrow(
				() -> new ObjectNotFoundException("O Motor especificado não foi encontrado em nossa base"));

		Marca marca = marcaRepository.findByNomeIgnoreCase(carroDTO.marca()).orElseThrow(
				() -> new ObjectNotFoundException("A Marca especificada não foi encontrada em nossa base"));
		Carro carro = Carro.fromDTO(carroDTO);
		carro.setMarca(marca);
		carro.setMotor(motor);
		carroRepository.saveAndFlush(carro);
		return carro;
	}

	public void delete(UUID id) {
		Carro obj = carroRepository.findById(id).orElse(null);
		if (obj == null) {
			throw new ObjectNotFoundException("Carro não encontrado");
		} else {
			carroRepository.delete(obj);
		}
	}

	public Carro getById(UUID id) {
		Carro obj = carroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
		return obj;
	}

	@Transactional
	public Carro update(Carro carro, UUID id) {
		Carro obj = carroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
		obj = carro;
		obj.setId(id);
		return carroRepository.saveAndFlush(obj);
	}

}
