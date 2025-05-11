package com.atomic.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.service.MotorService;

@RestController
@RequestMapping("/motores")
public class MotorController {

	@Autowired
	private MotorService service;

	@PostMapping
	public ResponseEntity<Motor> cadastrar(@RequestBody Motor motor) {
		return ResponseEntity.ok(service.register(motor));
	}
}
