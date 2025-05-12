package com.atomic.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public Marca register(Marca marca) {
		return marcaRepository.saveAndFlush(marca);
	}
	
	public List<Marca> getAll() {
		return marcaRepository.findAll();
	}

}
