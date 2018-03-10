package br.com.valhala.agenda.modelo;

import java.io.Serializable;

import br.com.valhala.agenda.modelo.enuns.EnumTipoTelefone;

public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer          id;
    private String           ddd;
    private String           numero;
    private EnumTipoTelefone tipo;

    private Contato contato = new Contato();

    public Telefone() {
        super();
    }

    public Telefone(Integer id, String codigo, String numero, EnumTipoTelefone tipo, Contato contato) {
        super();
        this.id = id;
        ddd = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.contato = contato;
    }

    public Telefone(String codigo, String numero, EnumTipoTelefone tipo, Contato contato) {
        super();
        ddd = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.contato = contato;
    }

    public Contato getContato() {
        return contato;
    }

    public String getDdd() {
        return ddd;
    }

    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public EnumTipoTelefone getTipo() {
        return tipo;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setDdd(String codigo) {
        ddd = codigo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(EnumTipoTelefone tipo) {
        this.tipo = tipo;
    }

}
