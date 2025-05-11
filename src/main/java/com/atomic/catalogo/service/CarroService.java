package com.atomic.catalogo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.repository.CarroRepository;
import com.atomic.catalogo.repository.MarcaRepository;
import com.atomic.catalogo.repository.MotorRepository;

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

	public CarroDTO register(CarroDTO carroDTO) {
		Carro carro = Carro.fromDTO(carroDTO);
		carro.setMarca(marcaRepository.findByNomeIgnoreCase(carroDTO.marca()));
		carro.setMotor(motorRepository.findById(carroDTO.motor()).get());
		carroRepository.saveAndFlush(carro);
		return CarroDTO.fromCarro(carro);
	}

}
