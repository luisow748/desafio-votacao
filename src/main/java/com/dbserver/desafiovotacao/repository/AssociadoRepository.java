package com.dbserver.desafiovotacao.repository;

import com.dbserver.desafiovotacao.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer> {


}
