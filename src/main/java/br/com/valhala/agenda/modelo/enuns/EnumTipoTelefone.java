package br.com.valhala.agenda.modelo.enuns;

public enum EnumTipoTelefone {

    RESIDENCIAL("RESIDENCIAL"), COMERCIAL("COMERCIAL"), CELULAR("CELULAR");

    private String descricao;

    EnumTipoTelefone(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
