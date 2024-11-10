package com.dbserver.desafiovotacao.service.output;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AssociadoOutputWrapper {
    private Integer associadoId;

    private String nome;
}
