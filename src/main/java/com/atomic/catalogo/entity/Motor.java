package com.atomic.catalogo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Motor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String tipo;
	private Integer cilindros;
	private Integer valvulas;
	private Integer potencia;
	private Integer torque;
	private String aspiracao;
	
	public Motor() {
	}
	
	public Motor(String tipo, Integer cilindros, Integer valvulas, Integer potencia, Integer torque,
			String aspiracao) {
		super();
		this.tipo = tipo;
		this.cilindros = cilindros;
		this.valvulas = valvulas;
		this.potencia = potencia;
		this.torque = torque;
		this.aspiracao = aspiracao;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCilindros() {
		return cilindros;
	}

	public void setCilindros(Integer cilindros) {
		this.cilindros = cilindros;
	}

	public Integer getValvulas() {
		return valvulas;
	}

	public void setValvulas(Integer valvulas) {
		this.valvulas = valvulas;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Integer getTorque() {
		return torque;
	}

	public void setTorque(Integer torque) {
		this.torque = torque;
	}

	public String getAspiracao() {
		return aspiracao;
	}

	public void setAspiracao(String aspiracao) {
		this.aspiracao = aspiracao;
	}
	
}
