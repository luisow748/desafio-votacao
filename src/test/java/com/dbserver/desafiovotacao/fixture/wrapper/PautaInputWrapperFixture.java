package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.input.PautaInputWrapper;

public class PautaInputWrapperFixture {

    public static PautaInputWrapper get() {
        PautaInputWrapper pautaInputWrapper = new PautaInputWrapper();
        pautaInputWrapper.setDescricao("Descrição");
        pautaInputWrapper.setNome("Nome");
        return pautaInputWrapper;
    }
}
