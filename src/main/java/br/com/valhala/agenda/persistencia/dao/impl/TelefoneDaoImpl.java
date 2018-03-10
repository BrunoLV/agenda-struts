package br.com.valhala.agenda.persistencia.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import br.com.valhala.agenda.modelo.Telefone;
import br.com.valhala.agenda.persistencia.dao.TelefoneDao;
import br.com.valhala.agenda.persistencia.mapper.TelefoneMapper;

public class TelefoneDaoImpl implements TelefoneDao {

    private SqlSession     session = null;
    private TelefoneMapper mapper  = null;

    public TelefoneDaoImpl() {
        super();
    }

    public TelefoneDaoImpl(SqlSession session) {
        super();
        this.session = session;
        this.mapper = this.session.getMapper(TelefoneMapper.class);
    }

    @Override
    public void inserir(Telefone t) {
        this.mapper.inserirTelefone(t);
    }

    @Override
    public void atualizar(Telefone t) {
        this.mapper.atualizarTelefone(t);
    }

    @Override
    public void remover(Integer id) {
        this.mapper.removerTelefone(id);
    }

    @Override
    public Telefone buscarPorId(Integer id) {
        return this.mapper.selecionarTelefonePorIdSemRelacionamento(id);
    }

    @Override
    public List<Telefone> buscarTodos() {
        return this.mapper.selecionarTodosTelefonesSemRelacionamento();
    }

    @Override
    public void deletarTelefonesDeUmContato(Integer idContato) {
        this.mapper.removerTelefonesDeUmContato(idContato);
    }

    @Override
    public List<Telefone> buscarTelefonesDeUmContato(Integer idContato) {
        return this.mapper.buscarTodosOsTelefonesDeUmContato(idContato);
    }
}
