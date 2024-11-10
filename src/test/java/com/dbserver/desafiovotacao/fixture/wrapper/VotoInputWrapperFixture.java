package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;

public class VotoInputWrapperFixture {

    public static VotoInputWrapper get(String valorVoto) {
        VotoInputWrapper votoInputWrapper = new VotoInputWrapper();
        votoInputWrapper.setAssociadoId(1);
        votoInputWrapper.setSessaoId(1);
        votoInputWrapper.setPautaId(1);
        votoInputWrapper.setValor(valorVoto);
        return votoInputWrapper;
    }
}
