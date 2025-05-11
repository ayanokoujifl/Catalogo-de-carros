package com.atomic.catalogo.entity.enums;

public enum Categoria {
	ESPORTIVO(4, "Esportivo"), SEDAN(3, "Sedan"), SUV(2, "SUV"), HATCH(1, "Hatch");

	private Integer id;
	private String descricao;

	private Categoria(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (Categoria x : Categoria.values()) {
			if (id == x.getId()) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}

}
