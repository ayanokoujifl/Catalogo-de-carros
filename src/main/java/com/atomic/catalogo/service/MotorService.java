package com.atomic.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.repository.MotorRepository;

@Service
public class MotorService {

	@Autowired
	private MotorRepository motorRepository;

	@Transactional
	public Motor register(Motor motor) {
		return motorRepository.saveAndFlush(motor);
	}
	
	public List<Motor> getAll() {
		return motorRepository.findAll();
	}

}
