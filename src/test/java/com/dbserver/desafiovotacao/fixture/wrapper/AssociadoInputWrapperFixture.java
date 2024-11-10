package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.input.AssociadoInputWrapper;

public class AssociadoInputWrapperFixture {

    public static AssociadoInputWrapper get() {
        AssociadoInputWrapper associadoInputWrapper = new AssociadoInputWrapper();
        associadoInputWrapper.setNome("Associado");
        return associadoInputWrapper;
    }
}
