package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Associado;
import com.dbserver.desafiovotacao.fixture.AssociadoFixture;
import com.dbserver.desafiovotacao.repository.AssociadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssociadoServiceImplTest {
    @InjectMocks
    AssociadoServiceImpl associadoService;
    @Mock
    AssociadoRepository associadoRepository;

    @Test
    public void DeveSalvarAssociado(){
        Associado associado = AssociadoFixture.get();
        when(associadoRepository.save(any())).thenReturn(associado);
        Associado associadoSalvo = associadoService.save(Associado.builder().build());
        assertEquals(1, associadoSalvo.getAssociadoId());
        verify(associadoRepository, times(1)).save(any());
    }

    @Test
    public void DeveRetornarAssociadoPorId(){
        Optional<Associado> associado = Optional.of(AssociadoFixture.get());
        when(associadoRepository.findById(1)).thenReturn(associado);
        Associado associadoRetornado = associadoService.findById(1);
        assertEquals(1, associadoRetornado.getAssociadoId());
        verify(associadoRepository, times(1)).findById(1);
    }

}