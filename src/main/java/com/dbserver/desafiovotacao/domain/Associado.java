package com.dbserver.desafiovotacao.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "associado")
@AllArgsConstructor
@NoArgsConstructor
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer associadoId;

    private String nome;
}
