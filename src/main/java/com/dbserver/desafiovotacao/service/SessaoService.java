package com.dbserver.desafiovotacao.service;

import com.dbserver.desafiovotacao.domain.Sessao;
import com.dbserver.desafiovotacao.service.input.SessaoInputWrapper;

public interface SessaoService {

    Sessao iniciar(SessaoInputWrapper sessaoInputWrapper);
    Sessao findById(Integer sessaoId);
    Boolean isValid(Integer sessaoId);
}
