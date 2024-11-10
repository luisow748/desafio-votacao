package com.dbserver.desafiovotacao.repository;

import com.dbserver.desafiovotacao.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer> {
}
