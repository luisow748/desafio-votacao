package com.dbserver.desafiovotacao.service.input;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PautaInputWrapper {

    private String nome;
    private String descricao;
}
