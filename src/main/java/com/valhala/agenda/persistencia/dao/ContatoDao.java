package com.valhala.agenda.persistencia.dao;

import com.valhala.agenda.modelo.Contato;

public interface ContatoDao extends BaseDao<Contato> {

    Contato buscarContatoComRelacionamentos(Integer id);

}
