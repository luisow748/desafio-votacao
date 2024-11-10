package com.dbserver.desafiovotacao.fixture;

import com.dbserver.desafiovotacao.domain.Sessao;

import java.time.LocalDateTime;

public class SessaoFixture {
    public static Sessao get() {
        LocalDateTime inicio = LocalDateTime.now();
        return Sessao.builder()
                .sessaoId(1)
                .prazoDuracao(10)
                .inicioSessao(inicio)
                .terminoSessao(inicio.plusMinutes(10L))
                .build();
    }
    public static Sessao getExpirada(){
        Sessao sessao = get();
        sessao.setTerminoSessao(LocalDateTime.now().minusMinutes(30));
        return sessao;
    }
    public static Sessao getWithId(Integer sessaoId) {
        Sessao sessao = get();
        sessao.setSessaoId(sessaoId);
        return sessao;
    }
}
