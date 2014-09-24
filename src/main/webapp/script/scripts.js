/**
 * Created by Bruno on 21/09/2014.
 */

function submeterManipulacao(acao, id) {
    switch (acao) {
        case "REMOVER":
            document.forms[0].setAttribute("action", "remover-contato.do");
            break;
        case "EDITAR":
            document.forms[0].setAttribute("action", "editar-contato.do");
            break;
        case "DETALHAR":
            document.forms[0].setAttribute("action", "detalhar-contato.do");
            break;
    }
    document.forms[0].id.value = id;
    document.forms[0].acao.value = acao;
    document.forms[0].submit();
}

function direcionarInclusao() {
    document.forms[0].setAttribute("action", "novo.do");
    document.forms[0].submit();
}

function submeterManipulacaoTelefone(acao, id) {
    switch (acao) {
        case "REMOVER":
            document.forms['listagemTelefones'].setAttribute("action", "remover-telefone.do");
            break;
        case "EDITAR":
            document.forms['listagemTelefones'].setAttribute("action", "editar-telefone.do");
            break;
    }
    document.forms['listagemTelefones'].id.value = id;
    document.forms['listagemTelefones'].acao.value = acao;
    document.forms['listagemTelefones'].submit();
}

function direcionarInclusaoTelefone() {
    document.forms['listagemTelefones'].setAttribute('action', 'novo-telefone.do')
    document.forms['listagemTelefones'].submit();
}