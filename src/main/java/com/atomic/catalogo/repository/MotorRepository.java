package com.atomic.catalogo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atomic.catalogo.entity.Motor;

public interface MotorRepository extends JpaRepository<Motor, UUID>{

}
