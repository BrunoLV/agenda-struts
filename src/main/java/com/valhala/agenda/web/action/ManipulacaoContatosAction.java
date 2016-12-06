package com.valhala.agenda.web.action;

import com.valhala.agenda.business.ContatoBusiness;
import com.valhala.agenda.business.TelefoneBusiness;
import com.valhala.agenda.modelo.Contato;
import com.valhala.agenda.modelo.Telefone;
import com.valhala.agenda.web.forms.ContatoActionForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Bruno on 13/09/2014.
 */
public class ManipulacaoContatosAction extends Action {

	private static final String REMOCAO_SUCESSO = "REMOCAO_SUCESSO";
	private static final String EDICAO_SUCESSO = "EDICAO_SUCESSO";
	private static final String INSERCAO_SUCESSO = "INSERCAO_SUCESSO";
	private static final String PREPARACAO_SUCESSO = "PREPARACAO_SUCESSO";
	private static final String DETALHE_SUCESSO = "DETALHE_SUCESSO";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ContatoActionForm actionForm = (ContatoActionForm) form;

		String forward = null;

		SqlSession session = (SqlSession) request.getAttribute("sessaoBanco");
		ContatoBusiness business = new ContatoBusiness(session);
		TelefoneBusiness telefoneBusiness = new TelefoneBusiness(session);

		if (actionForm.getAcao().equals("REMOVER")) {
			forward = this.removerRegistro(mapping, actionForm, request, response, business);
		} else if (actionForm.getAcao().equals("CADASTRAR")) {
			forward = this.cadastrarEditarRegistro(mapping, actionForm, request, response, business);
		} else if (actionForm.getAcao().equals("EDITAR")) {
			forward = this.prepararEdicao(mapping, actionForm, request, response, business);
		} else if (actionForm.getAcao().equals("DETALHAR")) {
			forward = this.detalharContato(mapping, actionForm, request, response, business, telefoneBusiness);
		}
		return mapping.findForward(forward);
	}

	/*
	 * Método auxiliar para a ação de remocao de registros.
	 */
	private String removerRegistro(ActionMapping mapping, ContatoActionForm form, HttpServletRequest request,
			HttpServletResponse response, ContatoBusiness business) throws Exception {
		business.removerContato(form.getId());

		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("label.message.remocao.sucesso"));
		saveMessages(request, messages);
		return REMOCAO_SUCESSO;
	} // fim do método removerRegistro

	/*
	 * Método auxiliar para a ação de cadastro/edicao de registros.
	 */
	private String cadastrarEditarRegistro(ActionMapping mapping, ContatoActionForm form, HttpServletRequest request,
			HttpServletResponse response, ContatoBusiness business) throws Exception {
		String forward;
		Contato contato = new Contato();
		if (form.getId() == null || form.getId().equals(Integer.valueOf("0"))) {
			BeanUtils.copyProperties(contato, form);
			business.inserirContato(contato);
			forward = INSERCAO_SUCESSO;

			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("label.message.cadastro.sucesso"));
			saveMessages(request, messages);
		} else {
			contato = business.buscarContatoSemRelacionamentos(form.getId());
			BeanUtils.copyProperties(contato, form);
			business.editarContato(contato);
			forward = EDICAO_SUCESSO;

			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("label.message.edicao.sucesso"));
			saveMessages(request, messages);
		} // fim do bloco if/else

		return forward;
	} // fim do método cadastrarEditarRegistro

	private String prepararEdicao(ActionMapping mapping, ContatoActionForm form, HttpServletRequest request,
			HttpServletResponse response, ContatoBusiness business) throws Exception {
		Contato contato = business.buscarContatoSemRelacionamentos(form.getId());
		request.setAttribute("contato", contato);
		return PREPARACAO_SUCESSO;
	}

	private String detalharContato(ActionMapping mapping, ContatoActionForm form, HttpServletRequest request,
			HttpServletResponse response, ContatoBusiness business, TelefoneBusiness telefoneBusiness)
			throws Exception {
		Contato contato = business.buscarContatoSemRelacionamentos(form.getId());
		List<Telefone> telefones = telefoneBusiness.buscarTodosTelefonesDeUmContato(contato.getId());
		request.getSession().setAttribute("contatoDetalhado", contato);
		request.setAttribute("telefones", telefones);
		return DETALHE_SUCESSO;
	}

}
