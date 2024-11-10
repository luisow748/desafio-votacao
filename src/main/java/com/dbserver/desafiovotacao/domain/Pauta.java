package com.dbserver.desafiovotacao.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "pauta")
@AllArgsConstructor
@NoArgsConstructor
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pautaId;

    private String nome;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "sessaoId")
    private Sessao sessao = null;

}
