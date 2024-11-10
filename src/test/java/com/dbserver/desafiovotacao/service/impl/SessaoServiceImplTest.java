package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Sessao;
import com.dbserver.desafiovotacao.exception.RecursoInexistenteException;
import com.dbserver.desafiovotacao.fixture.SessaoFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.SessaoInputWrapperFixture;
import com.dbserver.desafiovotacao.repository.SessaoRepository;
import com.dbserver.desafiovotacao.service.input.SessaoInputWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessaoServiceImplTest {
    @InjectMocks
    SessaoServiceImpl sessaoService;

    @Mock
    SessaoRepository sessaoRepository;

    @Test
    void DeveIniciarSessao(){
        Sessao sessao = SessaoFixture.get();
        when(sessaoRepository.save(any())).thenReturn(sessao);
        SessaoInputWrapper sessaoInputWrapper = SessaoInputWrapperFixture.get();
        Sessao sessaoIniciada = sessaoService.iniciar(sessaoInputWrapper);
        assertEquals(10, sessaoIniciada.getPrazoDuracao());
        assertEquals(1, sessaoIniciada.getSessaoId());
    }
    @Test
    void NaoDeveRetornarSessaoPorId() {
        assertThrows(RecursoInexistenteException.class, () -> sessaoService.findById(1));
    }

    @Test
    void DeveRetornarSessaoPorId() {
        Sessao sessao = SessaoFixture.get();
        when(sessaoRepository.findById(any())).thenReturn(Optional.of(sessao));
        Sessao sessaoRetornada = sessaoService.findById(1);
        assertEquals(10, sessaoRetornada.getPrazoDuracao());
        assertEquals(1, sessaoRetornada.getSessaoId());
    }

    @Test
    void DeveVerificarSessaoValida() {
        Sessao sessao = SessaoFixture.get();
        when(sessaoRepository.findById(any())).thenReturn(Optional.of(sessao));
        Boolean isSessaoValida = sessaoService.isValid(1);
        assertEquals(true, isSessaoValida);
    }

    @Test
    void DeveVerificarSessaoExpirada() {
        Sessao sessao = SessaoFixture.getExpirada();
        when(sessaoRepository.findById(any())).thenReturn(Optional.of(sessao));
        Boolean isSessaoValida = sessaoService.isValid(1);
        assertEquals(false, isSessaoValida);
    }
}
