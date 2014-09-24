package com.valhala.agenda.modelo;

import java.io.Serializable;

public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String codigo;
    private String numero;
    private TipoTelefone tipo;

    private Contato contato = new Contato();

    public Telefone() {
        super();
    }

    public Telefone(Integer id, String codigo, String numero, TipoTelefone tipo, Contato contato) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.contato = contato;
    }

    public Telefone(String codigo, String numero, TipoTelefone tipo, Contato contato) {
        super();
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.contato = contato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}
