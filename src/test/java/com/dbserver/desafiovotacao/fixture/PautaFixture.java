package com.dbserver.desafiovotacao.fixture;

import com.dbserver.desafiovotacao.domain.Pauta;

public class PautaFixture {

    public static Pauta get(){
        return Pauta.builder()
                .pautaId(1)
                .descricao("Pauta descrição")
                .nome("Pauta 1")
                .build();
    }
    public static Pauta getWithId(Integer pautaId){
        return Pauta.builder()
                .pautaId(pautaId)
                .descricao("Pauta descrição")
                .nome("Pauta 1")
                .build();
    }
}
