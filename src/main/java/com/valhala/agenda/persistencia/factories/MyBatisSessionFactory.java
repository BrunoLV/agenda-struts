package com.valhala.agenda.persistencia.factories;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * Classe utilizada para prover conexoes como banco de dados para a aplicacao.
 */
public class MyBatisSessionFactory {

	private static final Logger LOGGER = Logger.getLogger(MyBatisSessionFactory.class);

	private static final String CONFIG_RESOURCE = "mybatis-config.xml";
	private static SqlSessionFactory factory;

	/*
	 * Bloco statico para inicialização da session do MyBatis
	 */
	static {
		try {
			Reader reader = Resources.getResourceAsReader(CONFIG_RESOURCE);
			if (factory == null) {
				factory = new SqlSessionFactoryBuilder().build(reader);
			} // fim do bloco if
		} catch (IOException e) {
			LOGGER.error(String.format("Ocorreu um erro ao obter a sessao. Erro: %s", e.getMessage()), e);
		} // fim do bloco try/catch
	} // fim do bloco static

	public static SqlSessionFactory getSessionFactory() {
		return factory;
	}

} // fim da classe MyBatisSessionFactory