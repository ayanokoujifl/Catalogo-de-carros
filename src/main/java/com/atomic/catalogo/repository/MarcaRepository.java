package com.atomic.catalogo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atomic.catalogo.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM marca WHERE LOWER(nome) = LOWER(?1) limit 1")
	Optional<Marca> findByNomeIgnoreCase(String nome);

}
