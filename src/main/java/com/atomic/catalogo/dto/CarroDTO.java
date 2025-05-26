package com.atomic.catalogo.dto;

import com.atomic.catalogo.entity.Carro;

public record CarroDTO(String id, String modelo, String ano, String descricao, String combustivel,
		String tipoTransmissao, String tracao, Integer marchas, Integer velocidadeMaxima, String direcao, String freios,
		String categoria, String imagem, String marca, String motor) {

	public static CarroDTO fromCarro(Carro carro, String marca, String motor) {
		String id = carro.getId() != null ? carro.getId().toString() : null;
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
		String categoria = carro.getCategoria().getDescricao();
		String imagem = carro.getImagem();
		String marcaNome = marca;
		String motorId = motor;
		return new CarroDTO(id, modelo, ano, descricao, combustivel, tipoTransmissao, tracao, marchas, velocidadeMaxima,
				direcao, freios, categoria, imagem, marcaNome, motorId);
	}
}
