package com.atomic.catalogo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.entity.enums.Categoria;
import com.atomic.catalogo.repository.CarroRepository;
import com.atomic.catalogo.repository.MarcaRepository;
import com.atomic.catalogo.repository.MotorRepository;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner {

	@Autowired
	private MarcaRepository marcaRepo;

	@Autowired
	private MotorRepository motorRepo;

	@Autowired
	private CarroRepository carroRepo;

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		}

}
