package com.valhala.agenda.web.handlers;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Bruno on 21/09/2014.
 */
public class CustomExceptionHandler extends ExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(CustomExceptionHandler.class);

	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {

		LOGGER.error(String.format("Ocorreu um erro durante a execução da ação. Erro: %s", ex.getMessage()), ex);

		request.setAttribute("mensagem", ex.getMessage());
		return super.execute(ex, ae, mapping, formInstance, request, response);
	} // fim do metodo execute

} // fim da classe CustomExceptionHandler