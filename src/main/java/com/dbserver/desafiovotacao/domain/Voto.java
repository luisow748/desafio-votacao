package com.dbserver.desafiovotacao.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voto")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer votoId;
    private String valor;
    @OneToOne
    @JoinColumn(name = "sessaoId")
    private Sessao sessao;

    @ManyToOne
    @JoinColumn(name = "pautaId")
    private Pauta pauta;

    @OneToOne
    @JoinColumn(name = "associadoId")
    private Associado associado;


}
