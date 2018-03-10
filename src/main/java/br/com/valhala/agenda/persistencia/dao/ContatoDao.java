package br.com.valhala.agenda.persistencia.dao;

import br.com.valhala.agenda.modelo.Contato;

public interface ContatoDao extends BaseDao<Contato> {

    Contato buscarContatoComRelacionamentos(Integer id);

}
