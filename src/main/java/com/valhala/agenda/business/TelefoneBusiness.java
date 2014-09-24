package com.valhala.agenda.business;

import com.valhala.agenda.exception.BusinessException;
import com.valhala.agenda.modelo.Telefone;
import com.valhala.agenda.persistencia.dao.TelefoneDao;
import com.valhala.agenda.persistencia.dao.impl.TelefoneDaoImpl;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Bruno on 16/09/2014.
 */
public class TelefoneBusiness {

    private TelefoneDao telefoneDao;
    private SqlSession session;

    public TelefoneBusiness() {
        super();
    }

    public TelefoneBusiness(SqlSession session) {
        super();
        this.session = session;
        this.telefoneDao = new TelefoneDaoImpl(this.session);
    }

    public void inserirTelefone(Telefone telefone) throws BusinessException {
        try {
            this.telefoneDao.inserir(telefone);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            throw new BusinessException("Ocorreu um erro ao inserir o telefone.", e);
        }
    }

    public void editarTelefone(Telefone telefone) throws BusinessException {
        try {
            this.telefoneDao.atualizar(telefone);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            throw new BusinessException("Ocorreu um erro ao editar o telefone", e);
        }
    }

    public void removerTelefone(Integer id) throws BusinessException {
        try {
            this.telefoneDao.remover(id);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            throw new BusinessException("Ocorreu um erro ao remover o telefone.", e);
        }
    }

    public Telefone buscarTelefonePorId(Integer id) throws BusinessException {
        Telefone telefone;
        try {
            telefone = this.telefoneDao.buscarPorId(id);
        } catch (Exception e) {
            throw new BusinessException("Ocorreu um erro ao buscar o telefone.", e);
        }
        return telefone;
    }

    public List<Telefone> buscarTodosTelefonesDeUmContato(Integer idContato) throws BusinessException {
        List<Telefone> telefones;
        try {
            telefones = this.telefoneDao.buscarTelefonesDeUmContato(idContato);
        } catch (Exception e) {
            throw new BusinessException("Ocorreu um erro ao buscar o telefone.", e);
        }
        return telefones;
    }

}
