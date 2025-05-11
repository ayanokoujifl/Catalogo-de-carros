package com.atomic.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atomic.catalogo.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	Marca findByNomeIgnoreCase(String nome);

}
