package com.dbserver.desafiovotacao.service.output;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PautaOutputWrapper  {
    private Integer pautaId;
    private String nome;
    private String descricao;

}
