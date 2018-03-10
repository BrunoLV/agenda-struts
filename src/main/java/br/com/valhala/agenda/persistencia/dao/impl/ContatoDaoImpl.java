package br.com.valhala.agenda.persistencia.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import br.com.valhala.agenda.modelo.Contato;
import br.com.valhala.agenda.persistencia.dao.ContatoDao;
import br.com.valhala.agenda.persistencia.mapper.ContatoMapper;

public class ContatoDaoImpl implements ContatoDao {

    private SqlSession    session       = null;
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
