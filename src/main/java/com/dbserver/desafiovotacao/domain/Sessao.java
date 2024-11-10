package com.dbserver.desafiovotacao.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sessao")
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessaoId;

    private Integer prazoDuracao;
    private Integer pautaId;

    private LocalDateTime inicioSessao;
    private LocalDateTime terminoSessao;

}
