package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Sessao;
import com.dbserver.desafiovotacao.exception.RecursoInexistenteException;
import com.dbserver.desafiovotacao.repository.SessaoRepository;
import com.dbserver.desafiovotacao.service.SessaoService;
import com.dbserver.desafiovotacao.service.input.SessaoInputWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessaoServiceImpl implements SessaoService {
    private final SessaoRepository sessaoRepository;

    @Override
    public Sessao iniciar(SessaoInputWrapper inputWrapper) {
        var inicioSessao = LocalDateTime.now();
        var prazoDuracao = Math.max(inputWrapper.getPrazoDuracao(), 1);

        Sessao sessaoIniciada = Sessao.builder()
                .prazoDuracao(prazoDuracao)
                .pautaId(inputWrapper.getPautaId())
                .inicioSessao(inicioSessao)
                .terminoSessao(inicioSessao.plusMinutes(prazoDuracao))
                .build();
        return sessaoRepository.save(sessaoIniciada);
    }

    @Override
    public Sessao findById(Integer sessaoId) {
        return sessaoRepository.findById(sessaoId)
                .orElseThrow(() -> new RecursoInexistenteException("Sessão Inexistente"));
    }

    @Override
    public Boolean isValid(Integer sessaoId) {
        var horarioAtual = LocalDateTime.now();
        return sessaoRepository.findById(sessaoId)
                .filter(sessao -> sessao.getTerminoSessao().isAfter(horarioAtual))
                .isPresent();
    }
}
