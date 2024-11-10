package com.dbserver.desafiovotacao.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class RecursoInexistenteException extends RuntimeException {
    public RecursoInexistenteException(String message) {
        super(message);
    }
}
