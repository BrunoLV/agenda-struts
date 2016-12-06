package com.valhala.agenda.web.action;

import com.valhala.agenda.business.ContatoBusiness;
import com.valhala.agenda.modelo.Contato;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListagemContatosAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SqlSession session = (SqlSession) request.getAttribute("sessaoBanco");
		ContatoBusiness business = new ContatoBusiness(session);

		List<Contato> contatos = business.listarTodosContatos();
		request.setAttribute("contatos", contatos);

		return mapping.findForward("SUCESSO");
	}

}
