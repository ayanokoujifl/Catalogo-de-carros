package com.atomic.catalogo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.entity.enums.Categoria;
import com.atomic.catalogo.repository.CarroRepository;
import com.atomic.catalogo.repository.MarcaRepository;
import com.atomic.catalogo.repository.MotorRepository;
import com.atomic.catalogo.service.exception.ObjectNotFoundException;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class CarroServiceTest {

	// Mocks
	@Mock
	CarroRepository carroRepository;

	@Mock
	MarcaRepository marcaRepository;

	@Mock
	MotorRepository motorRepository;

	// Service
	@Autowired
	@InjectMocks
	CarroService carroService;

	// Testes

	@Test
	public void registerTest_MotorAndMarcaExists_Success() {

		// Arrange: Criar as entidades necessárias
		Motor motor = new Motor("Motor Teste", 1, 8, 200, 200, "Natural");
		motor.setId(UUID.randomUUID());
		Marca marca = new Marca(1, "Marca Teste", "Brasil", "2000");
		Carro carro = new Carro("Carro Teste", "2004", "Carro Teste", "Alcool", "Automatico", "Traseira", 5, 180,
				"Elétrica", "ABS", Categoria.HATCH, null, marca, motor);
		carro.setId(UUID.randomUUID());
		CarroDTO carroDTO = CarroDTO.fromCarro(carro);

		when(motorRepository.findById(any())).thenReturn(Optional.of(motor));
		when(marcaRepository.findByNomeIgnoreCase(any())).thenReturn(Optional.of(marca));
		// Act: chamar o método register
		carroService.register(carroDTO);
		// Assert: verificar se o carro foi salvo com os componentes corretos
		ArgumentCaptor<Carro> captor = ArgumentCaptor.forClass(Carro.class);
		verify(carroRepository).save(captor.capture());
		Carro carroSalvo = captor.getValue();
		assertThat(carroSalvo.getMarca()).isEqualTo(marca);
		assertThat(carroSalvo.getMotor()).isEqualTo(motor);

	}
	
	@Test
	public void registerTest_MotorNotFound_ThrowException() {
		// Arrange: Criar as entidades necessárias
		Motor motor = new Motor("Motor Teste", 1, 8, 200, 200, "Natural");
		motor.setId(UUID.randomUUID());
		Marca marca = new Marca(1, "Marca Teste", "Brasil", "2000");
		Carro carro = new Carro("Carro Teste", "2004", "Carro Teste", "Alcool", "Automatico", "Traseira", 5, 180,
				"Elétrica", "ABS", Categoria.HATCH, null, marca, motor);
		carro.setId(UUID.randomUUID());
		CarroDTO carroDTO = CarroDTO.fromCarro(carro);

		when(motorRepository.findById(any())).thenReturn(Optional.empty());
		
		// Act: chamar o método register
		assertThatThrownBy(() -> carroService.register(carroDTO))
			.isInstanceOf(ObjectNotFoundException.class)
			.hasMessage("O Motor especificado não foi encontrado em nossa base");
	}

}
