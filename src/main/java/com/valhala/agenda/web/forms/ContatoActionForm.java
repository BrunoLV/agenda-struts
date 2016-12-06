package com.valhala.agenda.web.forms;

import org.apache.struts.validator.ValidatorForm;

public class ContatoActionForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String acao;

	public ContatoActionForm() {
		super();
	}

	public ContatoActionForm(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
}
