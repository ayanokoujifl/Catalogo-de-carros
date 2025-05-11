package com.atomic.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
