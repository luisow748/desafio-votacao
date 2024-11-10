package com.dbserver.desafiovotacao.service.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContabilizacaoOutputWrapper {
    private Integer votosSim;
    private Integer votosNao;
    private String resultado;
}
