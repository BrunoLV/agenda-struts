package com.valhala.agenda.persistencia.mapper;

import com.valhala.agenda.modelo.Telefone;

import java.util.List;

public interface TelefoneMapper {

    void inserirTelefone(Telefone telefone);

    void atualizarTelefone(Telefone telefone);

    void removerTelefone(Integer id);

    void removerTelefonesDeUmContato(Integer idContato);

    List<Telefone> selecionarTodosTelefonesSemRelacionamento();

    Telefone selecionarTelefonePorIdSemRelacionamento(Integer id);

    Telefone selecionarTelefonePorIdComRelacionamento(Integer id);

    List<Telefone> buscarTodosOsTelefonesDeUmContato(Integer idContato);

}
