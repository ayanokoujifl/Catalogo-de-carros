package com.atomic.catalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.repository.MotorRepository;

@Service
public class MotorService {

	@Autowired
	private MotorRepository motorRepository;

	public Motor register(Motor motor) {
		return motorRepository.saveAndFlush(motor);
	}

}
