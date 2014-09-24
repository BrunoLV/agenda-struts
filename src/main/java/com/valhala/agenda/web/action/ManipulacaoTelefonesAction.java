package com.valhala.agenda.web.action;

import com.valhala.agenda.business.TelefoneBusiness;
import com.valhala.agenda.modelo.Telefone;
import com.valhala.agenda.modelo.TipoTelefone;
import com.valhala.agenda.web.forms.TelefoneActionForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Bruno on 15/09/2014.
 */
public class ManipulacaoTelefonesAction extends Action {

    private static final String REMOCAO_SUCESSO = "REMOCAO_SUCESSO";
    private static final String EDICAO_SUCESSO = "EDICAO_SUCESSO";
    private static final String INSERCAO_SUCESSO = "INSERCAO_SUCESSO";
    private static final String PREPARACAO_SUCESSO = "PREPARACAO_SUCESSO";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        TelefoneActionForm actionForm = (TelefoneActionForm) form;

        String forward = null;

        SqlSession session = (SqlSession) request.getAttribute("sessaoBanco");
        TelefoneBusiness business = new TelefoneBusiness(session);

        if (actionForm.getAcao().equals("REMOVER")) {
            forward = this.removerRegistro(mapping, actionForm, request, response, business);
        } else if (actionForm.getAcao().equals("CADASTRAR")) {
            forward = this.cadastrarEditarRegistro(mapping, actionForm, request, response, business);
        } else if (actionForm.getAcao().equals("EDITAR")) {
            forward = this.prepararEdicao(mapping, actionForm, request, response, business);
        }

        return mapping.findForward(forward);
    }

    private String removerRegistro(ActionMapping mapping, TelefoneActionForm form, HttpServletRequest request, HttpServletResponse response, TelefoneBusiness business) throws Exception {
        business.removerTelefone(form.getId());
        List<Telefone> telefones = business.buscarTodosTelefonesDeUmContato(form.getIdContato());
        request.setAttribute("telefones", telefones);

        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("label.message.remocao.sucesso"));
        saveMessages(request, messages);
        return REMOCAO_SUCESSO;
    }

    /*
    Método auxiliar para a ação de cadastro/edicao de registros.
    */
    private String cadastrarEditarRegistro(ActionMapping mapping,
                                           TelefoneActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response,
                                           TelefoneBusiness business) throws Exception {
        String forward;
        Telefone telefone = new Telefone();
        if (form.getId() == null || form.getId().equals(Integer.valueOf("0"))) {
            BeanUtils.copyProperties(telefone, form);
            telefone.getContato().setId(form.getIdContato());
            telefone.setTipo(TipoTelefone.valueOf(form.getTipoTelefone()));
            business.inserirTelefone(telefone);
            forward = INSERCAO_SUCESSO;

            ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("label.message.cadastro.sucesso"));
            saveMessages(request, messages);
        } else {
            telefone = business.buscarTelefonePorId(form.getId());
            BeanUtils.copyProperties(telefone, form);
            telefone.getContato().setId(form.getIdContato());
            telefone.setTipo(TipoTelefone.valueOf(form.getTipoTelefone()));
            business.editarTelefone(telefone);
            forward = EDICAO_SUCESSO;

            ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("label.message.edicao.sucesso"));
            saveMessages(request, messages);
        } // fim do bloco if/else
        List<Telefone> telefones = business.buscarTodosTelefonesDeUmContato(form.getIdContato());
        request.setAttribute("telefones", telefones);
        return forward;
    } // fim do método cadastrarEditarRegistro

    private String prepararEdicao(ActionMapping mapping,
                                  TelefoneActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response,
                                  TelefoneBusiness business) throws Exception {
        Telefone telefone = business.buscarTelefonePorId(form.getId());
        request.setAttribute("telefone", telefone);
        return PREPARACAO_SUCESSO;
    }

}
