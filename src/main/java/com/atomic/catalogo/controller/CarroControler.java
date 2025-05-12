package com.atomic.catalogo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroControler {

	@Autowired
	private CarroService service;

	@PostMapping
	public ResponseEntity<CarroDTO> cadastrar(@RequestBody CarroDTO carroDTO) {
		Carro carro = service.register(carroDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(carro.getId().toString()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<CarroDTO>> getAll() {
		List<CarroDTO> carros = service.getAll();
		return ResponseEntity.ok(carros);
	}

}
