package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.output.SessaoOutputWrapper;

import java.time.LocalDateTime;

public class SessaoOutputWrapperFixture {
    public static SessaoOutputWrapper get() {
        SessaoOutputWrapper sessaoOutputWrapper = new SessaoOutputWrapper();
        sessaoOutputWrapper.setSessaoId(1);
        sessaoOutputWrapper.setInicioSessao(LocalDateTime.now());
        sessaoOutputWrapper.setTerminoSessao(LocalDateTime.now().plusMinutes(10));
        sessaoOutputWrapper.setPrazoDuracao(10);
        sessaoOutputWrapper.setPautaId("1");
        return sessaoOutputWrapper;
    }
}
