package com.dbserver.desafiovotacao.fixture.wrapper;

import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;
import com.dbserver.desafiovotacao.service.output.VotoOutputWrapper;

public class VotoOutputWrapperFixture {

    public static VotoOutputWrapper get(VotoInputWrapper input) {
        VotoOutputWrapper output = new VotoOutputWrapper();
        output.setVotoId(1);
        output.setPautaId(input.getPautaId());
        output.setValor(input.getValor());
        output.setSessaoId(input.getSessaoId());
        return output;
    }
}
