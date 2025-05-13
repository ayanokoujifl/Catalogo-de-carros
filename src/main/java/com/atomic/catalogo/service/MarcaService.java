package com.atomic.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.repository.MarcaRepository;
import com.atomic.catalogo.service.exception.ObjectNotFoundException;

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
			throw new ObjectNotFoundException("Marca não encontrada na base de dados");
		} else {
			marcaRepository.delete(obj);
		}
	}

	public Marca getById(Integer id) {
		Marca obj = marcaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada na base de dados"));
		return obj;
	}

	@Transactional
	public Marca update(Marca marca, Integer id) {
		Marca obj = marcaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada na base de dados"));
		obj.setNome(marca.getNome());
		obj.setAnoFundacao(marca.getAnoFundacao());
		obj.setPaisOrigem(marca.getPaisOrigem());
		return marcaRepository.saveAndFlush(obj);
	}
}
