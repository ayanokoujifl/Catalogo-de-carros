package com.atomic.catalogo.dto;

import java.util.UUID;

import com.atomic.catalogo.entity.Carro;

public record CarroDTO(String modelo, String ano, String descricao, String combustivel, String tipoTransmissao,
		String tracao, Integer marchas, Integer velocidadeMaxima, String direcao, String freios, String categoria,
		String imagem, String marca, UUID motor) {

	public static CarroDTO fromCarro(Carro carro) {
		String modelo = carro.getModelo();
		String ano = carro.getAno();
		String descricao = carro.getDescricao();
		String combustivel = carro.getCombustivel();
		String tipoTransmissao = carro.getTipoTransmissao();
		String tracao = carro.getTracao();
		Integer marchas = carro.getMarchas();
		Integer velocidadeMaxima = carro.getVelocidadeMaxima();
		String direcao = carro.getDirecao();
		String freios = carro.getFreios();
		String categoria = carro.getCategoria().name();
		String imagem = carro.getImagem();
		String marca = carro.getMarca().getNome();
		UUID motor = carro.getMotor().getId();

		return new CarroDTO(modelo, ano, descricao, combustivel, tipoTransmissao, tracao, marchas, velocidadeMaxima,
				direcao, freios, categoria, imagem, marca, motor);
	}
}
