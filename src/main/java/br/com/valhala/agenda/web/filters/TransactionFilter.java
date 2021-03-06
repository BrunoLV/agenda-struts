package br.com.valhala.agenda.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import br.com.valhala.agenda.persistencia.factories.MyBatisSessionFactory;

public class TransactionFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(TransactionFilter.class);

    @Override
    public void destroy() {
        LOGGER.info("Finalizando o TransactionFilter.");
    } // fim do metodo destroy

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        SqlSession session = MyBatisSessionFactory.getSessionFactory().openSession();
        try {
            session.getConnection().setAutoCommit(false);
            request.setAttribute("sessaoBanco", session);
            chain.doFilter(request, response);
        } catch (Exception e) {
            LOGGER.error(String.format("Ocorreu um erro: %s", e.getMessage()), e);
        } finally {
            session.close();
        } // fim do bloco try/catch
    } // fim do metodo doFilter

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        LOGGER.info("Iniciando o TransactionFilter.");
    } // fim do metodo init

}
