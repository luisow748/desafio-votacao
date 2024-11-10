package com.dbserver.desafiovotacao.fixture;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.domain.enums.ValorVotoEnum;
import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;

import java.util.ArrayList;
import java.util.List;

public class VotoFixture {

    public static Voto get(String valorVoto) {
        return Voto.builder()
                .votoId(1)
                .associado(AssociadoFixture.get())
                .sessao(SessaoFixture.get())
                .pauta(PautaFixture.get())
                .valor(valorVoto)
                .build();
    }

    public static Voto getFromInputWrapper(VotoInputWrapper input) {
        return Voto.builder()
                .valor(input.getValor())
                .pauta(PautaFixture.getWithId(input.getPautaId()))
                .sessao(SessaoFixture.getWithId(input.getSessaoId()))
                .associado(AssociadoFixture.getWithId(input.getAssociadoId()))
                .build();
    }
    public static List<Voto> getListAprovados(){
        List<Voto> votos = new ArrayList<>();
        votos.add(get(ValorVotoEnum.SIM.getValor()));
        votos.add(get(ValorVotoEnum.SIM.getValor()));
        votos.add(get(ValorVotoEnum.SIM.getValor()));
        votos.add(get(ValorVotoEnum.NAO.getValor()));
        return votos;
    }
}
