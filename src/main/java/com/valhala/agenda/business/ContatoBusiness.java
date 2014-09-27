package com.valhala.agenda.business;

import com.valhala.agenda.exception.BusinessException;
import com.valhala.agenda.modelo.Contato;
import com.valhala.agenda.persistencia.dao.ContatoDao;
import com.valhala.agenda.persistencia.dao.TelefoneDao;
import com.valhala.agenda.persistencia.dao.impl.ContatoDaoImpl;
import com.valhala.agenda.persistencia.dao.impl.TelefoneDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Classe de negócio para ações que envolvem Contato.
 */
public class ContatoBusiness {

    private static final Logger LOGGER = Logger.getLogger(ContatoBusiness.class);

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
        LOGGER.info("Iniciado o processo de insercao de contato.");
        try {
            this.contatoDao.inserir(contato);
            this.session.commit();
            LOGGER.info("Contato inserido com sucesso.");
        } catch (Exception e) {
            this.session.rollback();
            LOGGER.error(String.format("Ocorreu um erro ao inserir contato. Erro: %s", e.getMessage()), e);
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
        LOGGER.info("Iniciado o processo de atualizacao de contato.");
        try {
            this.contatoDao.atualizar(contato);
            this.session.commit();
            LOGGER.info("Contato atualizado com sucesso.");
        } catch (Exception e) {
            this.session.rollback();
            LOGGER.error(String.format("Ocorreu um erro ao atualizar o contato. Erro: %s", e.getMessage()), e);
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
        LOGGER.info("Iniciado o processo de buscar de todos os contatos registrados no sistema.");
        List<Contato> contatos;
        try {
            contatos = this.contatoDao.buscarTodos();
        } catch (Exception e) {
            LOGGER.error(String.format("Ocorreu um erro ao buscar os registros na base do sistema. Erro: %s", e.getMessage()), e);
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
        LOGGER.info("Iniciado o processo de busca de contato utilizando id trazendo apenas os dados de contato.");
        Contato contato;
        try {
            contato = this.contatoDao.buscarPorId(id);
        } catch (Exception e) {
            LOGGER.error(String.format("Ocorreu um erro ao buscar o registro na base do sistema. Erro: %s", e.getMessage()), e);
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
        LOGGER.info("Iniciado o proceso de busca de contato utilizando id trazendo dados do contato e relacionamentos.");
        Contato contato;
        try {
            contato = this.contatoDao.buscarContatoComRelacionamentos(id);
        } catch (Exception e) {
            LOGGER.error(String.format("Ocorreu um erro ao buscar o registro na base do sistema. Erro: %s", e.getMessage()), e);
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
        LOGGER.info("Iniciado o processo de remocao de contato da base do sistema.");
        try {
            this.telefoneDao.deletarTelefonesDeUmContato(id);
            this.contatoDao.remover(id);
            LOGGER.info("Contato removido com sucesso.");
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            LOGGER.error(String.format("Ocorreu um erro ao remover o registro da base do sistema. Erro: %s", e.getMessage()), e);
            throw new BusinessException("Ocorreu um erro na ação de remover constatos.", e);
        } // fim do bloco try/catch
    } // fim do método removerContato

} // fim da classe ContatoBusiness