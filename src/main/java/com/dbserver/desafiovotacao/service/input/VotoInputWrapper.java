package com.dbserver.desafiovotacao.service.input;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VotoInputWrapper {

    private String valor;
    private Integer sessaoId;
    private Integer pautaId;
    private Integer associadoId;

}
