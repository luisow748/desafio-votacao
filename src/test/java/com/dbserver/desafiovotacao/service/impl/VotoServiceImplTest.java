package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.domain.enums.ValorVotoEnum;
import com.dbserver.desafiovotacao.fixture.VotoFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.VotoInputWrapperFixture;
import com.dbserver.desafiovotacao.repository.VotoRepository;
import com.dbserver.desafiovotacao.service.AssociadoService;
import com.dbserver.desafiovotacao.service.SessaoService;
import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;
import com.dbserver.desafiovotacao.service.output.ContabilizacaoOutputWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.dbserver.desafiovotacao.service.impl.VotoServiceImpl.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VotoServiceImplTest {

    @InjectMocks
    VotoServiceImpl votoService;

    @Mock
    VotoRepository votoRepository;
    @Mock
    SessaoService sessaoService;
    @Mock
    AssociadoService associadoService;

    @Test
    void DeveVerificarVotoValido() {
        VotoInputWrapper votoInput = VotoInputWrapperFixture.get(ValorVotoEnum.NAO.getValor());
        when(sessaoService.isValid(any())).thenReturn(true);
        when(associadoService.isValid(any())).thenReturn(true);
        when(votoService.findByAssociado(any())).thenReturn(null);
        when(votoRepository.findByAssociadoAssociadoId(any())).thenReturn(Optional.empty());
        Boolean isValid = votoService.isValid(votoInput);
        assertEquals(true, isValid);
    }

    @Test
    void NaoDevePermitirVotoAssociadoQueJaVotou() {
        VotoInputWrapper votoInput = VotoInputWrapperFixture.get(ValorVotoEnum.NAO.getValor());
        when(sessaoService.isValid(any())).thenReturn(true);
        when(associadoService.isValid(any())).thenReturn(true);
        Optional<Voto> votoJaExistente = Optional.of(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        when(votoRepository.findByAssociadoAssociadoId(any())).thenReturn(votoJaExistente);
        Boolean isValid = votoService.isValid(votoInput);
        assertEquals(false, isValid);
    }

    @Test
    void NaoDevePermitirVotoComValorDiferenteDoAceito() {
        VotoInputWrapper votoInput = VotoInputWrapperFixture.get("Talvez");
        when(sessaoService.isValid(any())).thenReturn(true);
        when(associadoService.isValid(any())).thenReturn(true);
        when(votoRepository.findByAssociadoAssociadoId(any())).thenReturn(Optional.empty());
        Boolean isValid = votoService.isValid(votoInput);
        assertEquals(false, isValid);
    }

    @Test
    void DevePermitirVotoComValorAceito() {
        VotoInputWrapper votoInput = VotoInputWrapperFixture.get(ValorVotoEnum.NAO.getValor());
        when(sessaoService.isValid(any())).thenReturn(true);
        when(associadoService.isValid(any())).thenReturn(true);
        when(votoRepository.findByAssociadoAssociadoId(any())).thenReturn(Optional.empty());
        Boolean isValid = votoService.isValid(votoInput);
        assertEquals(true, isValid);
    }

    @Test
    void DeveRetornarContabilizacaoAprovada() {
        List<Voto> votos = new ArrayList<>();
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        ContabilizacaoOutputWrapper contabilizacao = votoService.getContabilizacao(votos);
        assertEquals(PAUTA_APROVADA, contabilizacao.getResultado());
    }

    @Test
    void DeveRetornarContabilizacaoReprovada() {
        List<Voto> votos = new ArrayList<>();
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        ContabilizacaoOutputWrapper contabilizacao = votoService.getContabilizacao(votos);
        assertEquals(PAUTA_REPROVADA, contabilizacao.getResultado());
    }

    @Test
    void DeveRetornarContabilizacaoEmpate() {
        List<Voto> votos = new ArrayList<>();
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.SIM.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        votos.add(VotoFixture.get(ValorVotoEnum.NAO.getValor()));
        ContabilizacaoOutputWrapper contabilizacao = votoService.getContabilizacao(votos);
        assertEquals(EMPATE_DE_VOTOS, contabilizacao.getResultado());
    }

}