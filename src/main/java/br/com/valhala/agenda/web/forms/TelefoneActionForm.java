package br.com.valhala.agenda.web.forms;

import org.apache.struts.validator.ValidatorForm;

import br.com.valhala.agenda.modelo.enuns.EnumTipoTelefone;

public class TelefoneActionForm extends ValidatorForm {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer idContato;
    private String  ddd;
    private String  numero;
    private String  tipoTelefone;
    private String  acao;

    private EnumTipoTelefone tipo;

    public String getAcao() {
        return acao;
    }

    public String getDdd() {
        return ddd;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public String getNumero() {
        return numero;
    }

    public EnumTipoTelefone getTipo() {
        return tipo;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public void setDdd(String codigo) {
        ddd = codigo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(EnumTipoTelefone tipo) {
        this.tipo = tipo;
        tipoTelefone = tipo.name();
    }

    public void setTipoTelefone(String tipo) {
        this.tipo = EnumTipoTelefone.valueOf(tipo);
        tipoTelefone = tipo;
    }

}
