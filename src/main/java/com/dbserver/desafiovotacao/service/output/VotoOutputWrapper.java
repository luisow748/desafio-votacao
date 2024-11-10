package com.dbserver.desafiovotacao.service.output;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VotoOutputWrapper {
    private Integer votoId;
    private String valor;
    private Integer sessaoId;
    private Integer pautaId;
}
