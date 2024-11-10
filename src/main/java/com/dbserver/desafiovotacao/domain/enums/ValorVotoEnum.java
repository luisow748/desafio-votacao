package com.dbserver.desafiovotacao.domain.enums;

public enum ValorVotoEnum {
    SIM( "SIM"),
    NAO( "NAO");

    private final String valor;

    ValorVotoEnum(String descricao) {

        this.valor = descricao;
    }

    public String getValor() {
        return this.valor;
    }
}
