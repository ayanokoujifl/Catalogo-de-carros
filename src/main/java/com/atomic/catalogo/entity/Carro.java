package com.atomic.catalogo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import org.hibernate.validator.constraints.URL;

import com.atomic.catalogo.dto.CarroDTO;
import com.atomic.catalogo.entity.enums.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Carro implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String modelo;
	private String ano;
	private String descricao;
	private String combustivel;
	private String tipoTransmissao;
	private String tracao;
	private Integer marchas;
	private Integer velocidadeMaxima;
	private String direcao;
	private String freios;
	private Categoria categoria;
	@Column(length = 2048)
	@URL(message = "URL inválida")
	private String imagem;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca",referencedColumnName = "id")
	private Marca marca;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motor", referencedColumnName = "id")
	private Motor motor;

	public static Carro fromDTO(CarroDTO carroDTO) {
		Carro carro = new Carro();
		carro.setModelo(carroDTO.modelo());
		carro.setAno(carroDTO.ano());
		carro.setDescricao(carroDTO.descricao());
		carro.setCombustivel(carroDTO.combustivel());
		carro.setTipoTransmissao(carroDTO.tipoTransmissao());
		carro.setTracao(carroDTO.tracao());
		carro.setMarchas(carroDTO.marchas());
		carro.setVelocidadeMaxima(carroDTO.velocidadeMaxima());
		carro.setDirecao(carroDTO.direcao());
		carro.setFreios(carroDTO.freios());
		carro.setCategoria(Categoria.toEnum(carroDTO.categoria()));
		carro.setImagem(carroDTO.imagem());
		return carro;
	}

	// Construtores
	public Carro() {
	}

	public Carro(UUID id, String modelo, String ano, String descricao, String combustivel, String tipoTransmissao,
			String tracao, Integer marchas, Integer velocidadeMaxima, String direcao, String freios,
			Categoria categoria, String imagem, Marca marca, Motor motor) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
		this.descricao = descricao;
		this.combustivel = combustivel;
		this.tipoTransmissao = tipoTransmissao;
		this.tracao = tracao;
		this.marchas = marchas;
		this.velocidadeMaxima = velocidadeMaxima;
		this.direcao = direcao;
		this.freios = freios;
		this.categoria = categoria;
		this.imagem = imagem;
		this.marca = marca;
		this.motor = motor;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getTipoTransmissao() {
		return tipoTransmissao;
	}

	public void setTipoTransmissao(String tipoTransmissao) {
		this.tipoTransmissao = tipoTransmissao;
	}

	public String getTracao() {
		return tracao;
	}

	public void setTracao(String tracao) {
		this.tracao = tracao;
	}

	public Integer getMarchas() {
		return marchas;
	}

	public void setMarchas(Integer marchas) {
		this.marchas = marchas;
	}

	public Integer getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(Integer velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getFreios() {
		return freios;
	}

	public void setFreios(String freios) {
		this.freios = freios;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

}
