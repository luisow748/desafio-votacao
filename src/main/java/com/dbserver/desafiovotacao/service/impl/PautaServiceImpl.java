package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Pauta;
import com.dbserver.desafiovotacao.exception.RecursoInexistenteException;
import com.dbserver.desafiovotacao.repository.PautaRepository;
import com.dbserver.desafiovotacao.service.PautaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PautaServiceImpl implements PautaService {
    private final PautaRepository pautaRepository;
    @Override
    public Pauta save(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta findById(Integer pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new RecursoInexistenteException("Pauta inexistente"));
    }
}
