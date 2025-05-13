package com.atomic.catalogo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.repository.MotorRepository;
import com.atomic.catalogo.service.exception.ObjectNotFoundException;

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

	public void delete(UUID id) {
		Motor obj = motorRepository.findById(id).orElse(null);
		if (obj == null) {
			throw new ObjectNotFoundException("Motor não encontrado na base de dados");
		} else {
			motorRepository.delete(obj);
		}
	}

	public Motor getById(UUID id) {
		Motor obj = motorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Motor não encontrado na base de dados"));
		return obj;
	}

	@Transactional
	public Motor update(Motor motor, UUID id) {
		Motor obj = motorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Motor não encontrado na base de dados"));
		obj = motor;
		obj.setId(id);
		return motorRepository.saveAndFlush(obj);
	}

}
