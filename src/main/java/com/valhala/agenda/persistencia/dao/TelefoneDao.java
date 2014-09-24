package com.valhala.agenda.persistencia.dao;

import com.valhala.agenda.modelo.Telefone;

import java.util.List;

public interface TelefoneDao extends BaseDao<Telefone> {

    void deletarTelefonesDeUmContato(Integer idContato);

    List<Telefone> buscarTelefonesDeUmContato(Integer idContato);

}
