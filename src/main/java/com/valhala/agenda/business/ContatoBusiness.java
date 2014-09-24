package com.valhala.agenda.business;

import com.valhala.agenda.exception.BusinessException;
import com.valhala.agenda.modelo.Contato;
import com.valhala.agenda.persistencia.dao.ContatoDao;
import com.valhala.agenda.persistencia.dao.TelefoneDao;
import com.valhala.agenda.persistencia.dao.impl.ContatoDaoImpl;
import com.valhala.agenda.persistencia.dao.impl.TelefoneDaoImpl;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Classe de negócio para ações que envolvem Contato.
 */
public class ContatoBusiness {

    private ContatoDao contatoDao;
    private TelefoneDao telefoneDao;
    private SqlSession session;

    public ContatoBusiness() {
        super();
    } // método construtor

    public ContatoBusiness(SqlSession session) {
        super();
        this.session = session;
        this.contatoDao = new ContatoDaoImpl(this.session);
        this.telefoneDao = new TelefoneDaoImpl(this.session);
    } // método construtor

    /**
     * Método utilizado para inserir um contato na base do sistema.
     *
     * @param contato
     * @throws Exception
     */
    public void inserirContato(Contato contato) throws BusinessException {
        try {
            this.contatoDao.inserir(contato);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            throw new BusinessException("Ocorreu um erro para inserir o contato.", e);
        } // fim do bloco try/catch
    } // fim do método inserirContato

    /**
     * Método utilizado paara editar um contato na base de dados do sistema.
     *
     * @param contato
     * @throws BusinessException
     */
    public void editarContato(Contato contato) throws BusinessException {
        try {
            this.contatoDao.atualizar(contato);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            throw new BusinessException("Ocorreu um erro para editar o contato.", e);
        } // fim do bloco try/catch
    } // fim do método editarContato

    /**
     * Método utilizado para listar todos contatos cadastrados no sistema.
     *
     * @return
     * @throws Exception
     */
    public List<Contato> listarTodosContatos() throws BusinessException {
        List<Contato> contatos;
        try {
            contatos = this.contatoDao.buscarTodos();
        } catch (Exception e) {
            throw new BusinessException("Ocorreu um erro ao executar a consulta dos contatos.", e);
        } // fim do bloco try/catch
        return contatos;
    } // fim do método listarTodosContatos

    /**
     * Método utilizado para buscar um contato sem seus relacionamentos no banco de dados.
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public Contato buscarContatoSemRelacionamentos(Integer id) throws BusinessException {
        Contato contato;
        try {
            contato = this.contatoDao.buscarPorId(id);
        } catch (Exception e) {
            throw new BusinessException("Ocorreu um erro ao buscar contato.", e);
        } // fim do bloco try/catch
        return contato;
    } // fim do método buscarContatoSemRelacionamentos

    /**
     * Método utilizado para buscar um contato com todos os seus relacionamentos.
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public Contato buscarContatoComRelacionamentos(Integer id) throws BusinessException {
        Contato contato;
        try {
            contato = this.contatoDao.buscarContatoComRelacionamentos(id);
        } catch (Exception e) {
            throw new BusinessException("Ocorreu um erro ao buscar o contato.", e);
        } // fim do bloco try/catch
        return contato;
    } // fim do método buscarContatoComRelacionamentos

    /**
     * Método utilizado para remover um contato da base de dados do sistema.
     *
     * @param id
     * @throws BusinessException
     */
    public void removerContato(Integer id) throws BusinessException {
        try {
            this.telefoneDao.deletarTelefonesDeUmContato(id);
            this.contatoDao.remover(id);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            throw new BusinessException("Ocorreu um erro na ação de remover constatos.", e);
        } // fim do bloco try/catch
    } // fim do método removerContato

} // fim da classe ContatoBusiness