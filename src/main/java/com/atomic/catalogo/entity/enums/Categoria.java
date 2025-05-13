package com.atomic.catalogo.entity.enums;

public enum Categoria {
	ESPORTIVO(4, "Esportivo"), SEDAN(3, "Sedan"), SUV(2, "SUV"), HATCH(1, "Hatch"),PICAPE(5, "Picape"),HIPERCARRO(6,"Hipercarro");

	private Integer id;
	private String name;

	private Categoria(Integer id, String descricao) {
		this.id = id;
		this.name = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return name;
	}

	public void setDescricao(String descricao) {
		this.name = descricao;
	}

	public static Categoria toEnum(String name) {
		if (name == null) {
			return null;
		}
		for (Categoria x : Categoria.values()) {
			if (name.equals(x.getDescricao())) {
				return x;
			}
		}
		throw new IllegalArgumentException("name inválido: " + name);
	}

}
