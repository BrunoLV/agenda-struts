package com.valhala.agenda.business;

import com.valhala.agenda.exception.BusinessException;
import com.valhala.agenda.modelo.Telefone;
import com.valhala.agenda.persistencia.dao.TelefoneDao;
import com.valhala.agenda.persistencia.dao.impl.TelefoneDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Classe de negócio para tratar de ações relacionadas a telefone dentro do sistema.
 */
public class TelefoneBusiness {

    private static final Logger LOGGER = Logger.getLogger(TelefoneBusiness.class);

    private TelefoneDao telefoneDao;
    private SqlSession session;

    public TelefoneBusiness() {
        super();
    } // fim do construtor

    public TelefoneBusiness(SqlSession session) {
        super();
        this.session = session;
        this.telefoneDao = new TelefoneDaoImpl(this.session);
    } // fim do construtor

    /**
     * Método utilizado para inserir um telefone na base do sistema.
     *
     * @param telefone
     * @throws BusinessException
     */
    public void inserirTelefone(Telefone telefone) throws BusinessException {
        LOGGER.info("Iniciado o processo de insercao de telefone na base do sistema.");
        try {
            this.telefoneDao.inserir(telefone);
            LOGGER.info("Telefone inserido com sucesso.");
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            LOGGER.error(String.format("Ocorreu um erro ao inserir o telefone. Erro: %s", e.getMessage()), e);
            throw new BusinessException("Ocorreu um erro ao inserir o telefone.", e);
        } // fim do bloco try/catch
    } // fim do método inserirTelefone

    /**
     * Método utilizado para atualizar um telefone na base do sistema.
     *
     * @param telefone
     * @throws BusinessException
     */
    public void editarTelefone(Telefone telefone) throws BusinessException {
        LOGGER.info("Iniciadoo o processo de atualizacao de telefone na base do sistema.");
        try {
            this.telefoneDao.atualizar(telefone);
            LOGGER.info("Telefone atualizado com sucesso.");
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            LOGGER.error(String.format("Ocorreu um erro ao atualizar o telefone. Erro: %s", e.getMessage()), e);
            throw new BusinessException("Ocorreu um erro ao editar o telefone", e);
        } // fim do bloco try/catch
    } // fim do metodo editarTelefone

    /**
     * Método utilizado para remover um telefone na base do sistema.
     *
     * @param id
     * @throws BusinessException
     */
    public void removerTelefone(Integer id) throws BusinessException {
        LOGGER.info("Iniciado o processo de remocao de telefone da base do sistema.");
        try {
            this.telefoneDao.remover(id);
            LOGGER.info("Telefone removido com sucesso.");
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            LOGGER.error(String.format("Ocorreu um erro ao remover o telefone. Erro: %s", e.getMessage()), e);
            throw new BusinessException("Ocorreu um erro ao remover o telefone.", e);
        } // fim do bloco try/catch
    } // fim do metodo removerTelefone

    /**
     * Metodo utilizado para buscar um telefone na base do sistema utilizando seu id.
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    public Telefone buscarTelefonePorId(Integer id) throws BusinessException {
        LOGGER.info("Iniciando o processo de busca de telefone.");
        Telefone telefone;
        try {
            telefone = this.telefoneDao.buscarPorId(id);
        } catch (Exception e) {
            LOGGER.error(String.format("Ocorreu um erro ao buscar o telefone. Erro: %s", e.getMessage()), e);
            throw new BusinessException("Ocorreu um erro ao buscar o telefone.", e);
        } // fim do bloco try/catch
        return telefone;
    } // fim do metodo buscarTelefonePorId

    /**
     * Metodo utilizado para buscar todos os telefones registrados na base do sistema de um determinado contato.
     *
     * @param idContato
     * @return
     * @throws BusinessException
     */
    public List<Telefone> buscarTodosTelefonesDeUmContato(Integer idContato) throws BusinessException {
        LOGGER.info(String.format("Iniciando a buscar dos telefones do contato %d", idContato));
        List<Telefone> telefones;
        try {
            telefones = this.telefoneDao.buscarTelefonesDeUmContato(idContato);
        } catch (Exception e) {
            LOGGER.error(String.format("Ocorreu um erro ao buscar os telefones. Erro: %s", e.getMessage()), e);
            throw new BusinessException("Ocorreu um erro ao buscar os telefones.", e);
        } // fim do bloco try/catch
        return telefones;
    } // fim do metod buscarTodosTelefonesDeUmContato

} // fim da classe TelefoneBusiness