package com.atomic.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroControler {

	@Autowired
	private CarroService service;

	@PostMapping
	public ResponseEntity<CarroDTO> cadastrar(@RequestBody CarroDTO carro) {
		return ResponseEntity.ok(service.register(carro));
	}
}
