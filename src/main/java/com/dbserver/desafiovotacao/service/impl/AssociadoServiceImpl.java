package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Associado;
import com.dbserver.desafiovotacao.exception.RecursoInexistenteException;
import com.dbserver.desafiovotacao.repository.AssociadoRepository;
import com.dbserver.desafiovotacao.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {
    private final AssociadoRepository associadoRepository;


    @Override
    public Associado save(Associado associado) {
        return associadoRepository.save(associado);
    }

    @Override
    public Associado findById(Integer associadoId) {
        return associadoRepository.findById(associadoId)
                .orElseThrow(() -> new RecursoInexistenteException("Associado inexistente"));
    }

    @Override
    public Boolean isValid(Integer associadoId) {
        return Objects.nonNull(findById(associadoId));
    }
}
