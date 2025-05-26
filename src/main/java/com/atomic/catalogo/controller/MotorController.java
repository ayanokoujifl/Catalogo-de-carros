package com.atomic.catalogo.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.service.MotorService;
import com.atomic.catalogo.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping("/motores")
public class MotorController {

	@Autowired
	private MotorService service;

	@PostMapping
	public ResponseEntity<Motor> register(@RequestBody Motor motor) {
		motor = service.register(motor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(motor.getId().toString()).toUri();
		return ResponseEntity.created(uri).body(motor);
	}

	@GetMapping
	public ResponseEntity<List<Motor>> getAll() {
		List<Motor> motores = service.getAll();
		return ResponseEntity.ok(motores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Motor> getById(@PathVariable String id) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		UUID uuid;
		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
			throw new ObjectNotFoundException(id + " não é um UUID válido. Por favor, verifique o ID informado.");
		}
		return ResponseEntity.ok(service.getById(uuid));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Motor> update(@RequestBody Motor motor, @PathVariable UUID id) {
		return ResponseEntity.ok(service.update(motor, id));
	}

}
