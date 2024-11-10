package com.dbserver.desafiovotacao.repository;

import com.dbserver.desafiovotacao.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
    Optional<Voto> findByAssociadoAssociadoId(Integer associadoId);
    Optional<List<Voto>> findBySessaoSessaoId(Integer sessaoId);
}
