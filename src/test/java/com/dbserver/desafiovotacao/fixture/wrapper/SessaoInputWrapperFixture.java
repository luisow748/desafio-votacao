package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.input.SessaoInputWrapper;

public class SessaoInputWrapperFixture {

    public static SessaoInputWrapper get() {
        SessaoInputWrapper inputWrapper = new SessaoInputWrapper();
        inputWrapper.setPrazoDuracao(2);
        inputWrapper.setPautaId(1);
        return inputWrapper;
    }
}
