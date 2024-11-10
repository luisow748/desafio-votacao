package com.dbserver.desafiovotacao.service.output;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class SessaoOutputWrapper {
    private Integer sessaoId;
    private Integer prazoDuracao;
    private String pautaId;
    private LocalDateTime inicioSessao;
    private LocalDateTime terminoSessao;
}
