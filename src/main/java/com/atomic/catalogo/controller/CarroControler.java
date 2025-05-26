package com.atomic.catalogo.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.service.CarroService;
import com.atomic.catalogo.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping("/carros")
public class CarroControler {

	@Autowired
	private CarroService service;

	@PostMapping
	public ResponseEntity<CarroDTO> register(@RequestBody CarroDTO carroDTO) {
		CarroDTO carro = service.register(carroDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.id()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<CarroDTO>> getAll() {
		List<CarroDTO> carros = service.getAll();
		return ResponseEntity.ok(carros);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarroDTO> getById(@PathVariable String id) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		UUID uuid;
		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
			throw new ObjectNotFoundException(id + " não é um UUID válido. Por favor, verifique o ID informado.");
		}

		CarroDTO carroDTO = service.getById(uuid);
		return ResponseEntity.ok(carroDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO carro, @PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(carro, id));
	}

}
