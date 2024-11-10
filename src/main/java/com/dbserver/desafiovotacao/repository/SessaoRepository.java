package com.dbserver.desafiovotacao.repository;

import com.dbserver.desafiovotacao.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
}
