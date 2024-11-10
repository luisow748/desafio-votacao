package com.dbserver.desafiovotacao.fixture;

import com.dbserver.desafiovotacao.domain.Associado;

public class AssociadoFixture {
    public static Associado get(){
        return Associado.builder()
                .associadoId(1)
                .nome("Associado 1")
                .build();
    }
    public static Associado getWithId(Integer associadoId){
        Associado associado = get();
        associado.setAssociadoId(associadoId);
        return associado;
    }
}
