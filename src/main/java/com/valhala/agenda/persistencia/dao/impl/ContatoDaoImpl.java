package com.valhala.agenda.persistencia.dao.impl;

import com.valhala.agenda.modelo.Contato;
import com.valhala.agenda.persistencia.dao.ContatoDao;
import com.valhala.agenda.persistencia.mapper.ContatoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ContatoDaoImpl implements ContatoDao {

    private SqlSession session = null;
    private ContatoMapper contatoMapper = null;

    public ContatoDaoImpl() {
        super();
    }

    public ContatoDaoImpl(SqlSession session) {
        super();
        this.session = session;
        this.contatoMapper = this.session.getMapper(ContatoMapper.class);
    }

    @Override
    public void inserir(Contato t) {
        this.contatoMapper.inserirContato(t);
    }

    @Override
    public void atualizar(Contato t) {
        this.contatoMapper.atualizarContato(t);
    }

    @Override
    public void remover(Integer id) {
        this.contatoMapper.removerContato(id);
    }

    @Override
    public Contato buscarPorId(Integer id) {
        return this.contatoMapper.buscarContatoPorIdSemRelacionamento(id);
    }

    @Override
    public List<Contato> buscarTodos() {
        return this.contatoMapper.buscarTodosContatos();
    }

    @Override
    public Contato buscarContatoComRelacionamentos(Integer id) {
        return this.contatoMapper.buscarContatoPorIdRelacionamentoFull(id);
    }
}
