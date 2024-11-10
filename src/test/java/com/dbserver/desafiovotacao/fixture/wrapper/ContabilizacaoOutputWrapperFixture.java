package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.domain.enums.ValorVotoEnum;
import com.dbserver.desafiovotacao.service.output.ContabilizacaoOutputWrapper;

import java.util.List;

import static com.dbserver.desafiovotacao.service.impl.VotoServiceImpl.PAUTA_APROVADA;
import static com.dbserver.desafiovotacao.service.impl.VotoServiceImpl.getQuantidadeVotos;

public class ContabilizacaoOutputWrapperFixture {
    public static ContabilizacaoOutputWrapper getFromListVotos(List<Voto> votos) {
        return ContabilizacaoOutputWrapper.builder()
                .votosSim(getQuantidadeVotos(votos, ValorVotoEnum.SIM))
                .votosNao(getQuantidadeVotos(votos, ValorVotoEnum.NAO))
                .resultado(PAUTA_APROVADA)
                .build();
    }
}
