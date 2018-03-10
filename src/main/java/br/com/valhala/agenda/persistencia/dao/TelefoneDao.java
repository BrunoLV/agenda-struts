package br.com.valhala.agenda.persistencia.dao;

import java.util.List;

import br.com.valhala.agenda.modelo.Telefone;

public interface TelefoneDao extends BaseDao<Telefone> {

    void deletarTelefonesDeUmContato(Integer idContato);

    List<Telefone> buscarTelefonesDeUmContato(Integer idContato);

}
