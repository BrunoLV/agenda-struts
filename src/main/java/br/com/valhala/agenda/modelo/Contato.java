package br.com.valhala.agenda.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Contato dentro do sistema.
 *
 * @author Bruno
 */
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer        id;
    private String         nome;
    private List<Telefone> telefones = new ArrayList<Telefone>();

    public Contato() {
        super();
    }

    public Contato(Integer id, String nome, List<Telefone> telefones) {
        super();
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
    }

    public Contato(String nome) {
        super();
        this.nome = nome;
    }

    public Contato(String nome, List<Telefone> telefones) {
        super();
        this.nome = nome;
        this.telefones = telefones;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

}
