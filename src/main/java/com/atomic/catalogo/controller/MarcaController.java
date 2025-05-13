package com.atomic.catalogo.controller;

import java.util.List;

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

import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.service.MarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	private MarcaService service;

	@PostMapping
	public ResponseEntity<Marca> cadastrar(@RequestBody Marca marca) {
		return ResponseEntity.ok(service.register(marca));
	}

	@GetMapping
	public ResponseEntity<List<Marca>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Marca> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Marca> update(@RequestBody Marca marca, @PathVariable Integer id) {
		return ResponseEntity.ok(service.update(marca, id));
	}
}
