package com.atomic.catalogo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.atomic.catalogo.entity.Marca;

@DataJpaTest
@ActiveProfiles("test")
public class MarcaRepositoryTest {

	@Autowired
	MarcaRepository marcaRepository;
	
	@Test
	@DisplayName("Deve retornar uma marca quando o nome existir, ignorando diferenças de case")
    void findByNomeIgnoreCase_deveRetornarMarca_quandoNomeExistirIgnorandoCase() {
        // Arrange: salvar uma marca no banco de teste
        Marca marca = new Marca();
        marca.setNome("Volkswagen");
        marcaRepository.save(marca);

        // Act: buscar com case diferente
        Optional<Marca> resultado = marcaRepository.findByNomeIgnoreCase("volksWAGEN");
        // Assert: garantir que encontrou a marca
        
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Volkswagen");
    }

    @Test
    @DisplayName("Deve retornar vazio quando o nome não existir, ignorando diferenças de case")
    void findByNomeIgnoreCase_deveRetornarVazio_quandoMarcaNaoExistir() {
        Optional<Marca> resultado = marcaRepository.findByNomeIgnoreCase("MarcaInexistente");
        assertThat(resultado).isEmpty();
    }
}
