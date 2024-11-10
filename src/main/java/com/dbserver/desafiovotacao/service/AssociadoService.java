package com.dbserver.desafiovotacao.service;

import com.dbserver.desafiovotacao.domain.Associado;


public interface AssociadoService {
    Associado save(Associado associado);
    Associado findById(Integer associadoId);
    Boolean isValid(Integer associadoId);
}
