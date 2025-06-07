package com.atomic.catalogo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atomic.catalogo.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, UUID>{

	@Query("SELECT c FROM Carro c JOIN FETCH c.marca JOIN FETCH c.motor WHERE c.id = :id")
	Optional<Carro> findByIdWithAssociations(@Param("id") UUID id);

	
}
