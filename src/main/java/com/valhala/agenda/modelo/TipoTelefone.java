package com.valhala.agenda.modelo;

public enum TipoTelefone {

	RESIDENCIAL("RESIDENCIAL"), COMERCIAL("COMERCIAL"), CELULAR("CELULAR");

	private String descricao;

	TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
