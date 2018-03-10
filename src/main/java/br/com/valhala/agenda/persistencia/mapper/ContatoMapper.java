package br.com.valhala.agenda.persistencia.mapper;

import java.util.List;

import br.com.valhala.agenda.modelo.Contato;

public interface ContatoMapper {

    void inserirContato(Contato contato);

    void atualizarContato(Contato contato);

    void removerContato(Integer id);

    List<Contato> buscarTodosContatos();

    Contato buscarContatoPorIdSemRelacionamento(Integer id);

    Contato buscarConstatosPorIdComRelacionamento(Integer id);

    Contato buscarContatoPorIdRelacionamentoFull(Integer id);

}
