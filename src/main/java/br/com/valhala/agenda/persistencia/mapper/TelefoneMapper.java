package br.com.valhala.agenda.persistencia.mapper;

import java.util.List;

import br.com.valhala.agenda.modelo.Telefone;

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
