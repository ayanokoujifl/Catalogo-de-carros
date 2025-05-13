package com.atomic.catalogo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atomic.catalogo.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	Optional<Marca> findByNomeIgnoreCase(String nome);

}
