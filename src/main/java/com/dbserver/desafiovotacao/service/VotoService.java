package com.dbserver.desafiovotacao.service;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;
import com.dbserver.desafiovotacao.service.output.ContabilizacaoOutputWrapper;

import java.util.List;


public interface VotoService {
    Voto save(VotoInputWrapper voto);
    Voto findByAssociado(Integer associadoId);

    List<Voto> findBySessao(Integer sessaoId);
    Boolean isValid(VotoInputWrapper votoInput);
    ContabilizacaoOutputWrapper getContabilizacao(List<Voto> votosValidos);
}
