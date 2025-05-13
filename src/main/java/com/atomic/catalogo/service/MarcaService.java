package com.atomic.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	@Transactional
	public Marca register(Marca marca) {
		return marcaRepository.saveAndFlush(marca);
	}

	public List<Marca> getAll() {
		return marcaRepository.findAll();
	}

	public void delete(Integer id) {
		Marca obj = marcaRepository.findById(id).orElse(null);
		if (obj == null) {
			throw new RuntimeException("Marca não encontrada");
		} else {
			marcaRepository.delete(obj);
		}
	}

	public Marca getById(Integer id) {
		Marca obj = marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		return obj;
	}

	@Transactional
	public Marca update(Marca marca, Integer id) {
		Marca obj = marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		obj.setNome(marca.getNome());
		obj.setAnoFundacao(marca.getAnoFundacao());
		obj.setPaisOrigem(marca.getPaisOrigem());
		return marcaRepository.saveAndFlush(obj);
	}
}
