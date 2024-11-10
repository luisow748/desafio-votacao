package com.dbserver.desafiovotacao.service;

import com.dbserver.desafiovotacao.domain.Pauta;

public interface PautaService {
    Pauta save(Pauta pauta);
    Pauta findById(Integer pautaId);
}
