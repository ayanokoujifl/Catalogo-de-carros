package com.atomic.catalogo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atomic.catalogo.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, UUID>{

}
