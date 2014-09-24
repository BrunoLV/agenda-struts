package com.valhala.agenda.persistencia.mapper;

import com.valhala.agenda.modelo.Contato;

import java.util.List;

public interface ContatoMapper {

    void inserirContato(Contato contato);

    void atualizarContato(Contato contato);

    void removerContato(Integer id);

    List<Contato> buscarTodosContatos();

    Contato buscarContatoPorIdSemRelacionamento(Integer id);

    Contato buscarConstatosPorIdComRelacionamento(Integer id);

    Contato buscarContatoPorIdRelacionamentoFull(Integer id);

}
