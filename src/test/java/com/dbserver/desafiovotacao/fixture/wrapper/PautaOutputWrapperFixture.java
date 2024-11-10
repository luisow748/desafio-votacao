package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.domain.Pauta;
import com.dbserver.desafiovotacao.service.output.PautaOutputWrapper;

public class PautaOutputWrapperFixture {
    public static PautaOutputWrapper getFromPauta(Pauta pauta) {
        PautaOutputWrapper pautaOutputWrapper = new PautaOutputWrapper();
        pautaOutputWrapper.setPautaId(pauta.getPautaId());
        pautaOutputWrapper.setDescricao(pauta.getDescricao());
        pautaOutputWrapper.setNome(pauta.getNome());
        return pautaOutputWrapper;
    }
}
