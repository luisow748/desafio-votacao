package com.dbserver.desafiovotacao.exception;

public class SessaoInvalidaException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Sessão inválida / finalizada";
    }
}