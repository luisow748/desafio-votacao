package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Pauta;
import com.dbserver.desafiovotacao.fixture.PautaFixture;
import com.dbserver.desafiovotacao.repository.PautaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PautaServiceImplTest {
    @InjectMocks
    PautaServiceImpl pautaService;
    @Mock
    PautaRepository pautaRepository;

    @Test
    public void DeveSalvarPauta(){
        Pauta pauta = PautaFixture.get();
        when(pautaRepository.save(any())).thenReturn(pauta);
        Pauta pautaSalva = pautaService.save(Pauta.builder().build());
        assertEquals(1, pautaSalva.getPautaId());
        verify(pautaRepository, times(1)).save(any());
    }

    @Test
    public void DeveRetornarAssociadoPorId(){
        Pauta pauta = PautaFixture.get();
        when(pautaRepository.findById(1)).thenReturn(Optional.ofNullable(pauta));
        Pauta pautaRetornada = pautaService.findById(1);
        assertEquals(1, pautaRetornada.getPautaId());
        verify(pautaRepository, times(1)).findById(1);
    }
}