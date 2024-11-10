package com.dbserver.desafiovotacao.service.input;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class SessaoInputWrapper {
    private Integer pautaId;
    private Integer prazoDuracao;
}
