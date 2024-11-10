package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.output.AssociadoOutputWrapper;

public class AssociadoOutputWrapperFixture {

    public static AssociadoOutputWrapper get() {
        AssociadoOutputWrapper associadoOutputWrapper = new AssociadoOutputWrapper();
        associadoOutputWrapper.setAssociadoId(1);
        associadoOutputWrapper.setNome("Associado");
        return associadoOutputWrapper;
    }
}
