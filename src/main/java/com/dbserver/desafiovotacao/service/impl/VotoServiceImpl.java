package com.dbserver.desafiovotacao.service.impl;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.domain.enums.ValorVotoEnum;
import com.dbserver.desafiovotacao.exception.RecursoInexistenteException;
import com.dbserver.desafiovotacao.exception.SessaoInvalidaException;
import com.dbserver.desafiovotacao.repository.VotoRepository;
import com.dbserver.desafiovotacao.service.*;
import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;
import com.dbserver.desafiovotacao.service.output.ContabilizacaoOutputWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class VotoServiceImpl implements VotoService {
    public static final String PAUTA_APROVADA = "Pauta Aprovada.";
    public static final String PAUTA_REPROVADA = "Pauta Reprovada.";
    public static final String EMPATE_DE_VOTOS = "Empate de votos";
    private final VotoRepository votoRepository;
    private final PautaService pautaService;
    private final SessaoService sessaoService;
    private final AssociadoService associadoService;

    @Override
    public Voto save(VotoInputWrapper votoInput) {
        if (isValid(votoInput)) {
            Voto novoVoto = Voto.builder()
                    .valor(votoInput.getValor())
                    .pauta(pautaService.findById(votoInput.getPautaId()))
                    .sessao(sessaoService.findById(votoInput.getSessaoId()))
                    .associado(associadoService.findById(votoInput.getAssociadoId()))

                    .build();
            return votoRepository.save(novoVoto);
        }
        throw new SessaoInvalidaException();
    }

    @Override
    public Voto findByAssociado(Integer associadoId) {
        return votoRepository.findByAssociadoAssociadoId(associadoId)
                .orElse(null);
    }

    @Override
    public List<Voto> findBySessao(Integer sessaoId) {
        ArrayList<Voto> votosPorSessao = new ArrayList<>(votoRepository.findBySessaoSessaoId(sessaoId)
                .orElseThrow(() -> new RecursoInexistenteException("Não há votos para essa sessão")));
        votosPorSessao.sort(Comparator.comparing(Voto::getValor));
        return votosPorSessao;
    }

    @Override
    public Boolean isValid(VotoInputWrapper votoInput) {
        boolean isPautaExists = Objects.nonNull((votoInput.getPautaId()));
        boolean isValidSessao = sessaoService.isValid(votoInput.getSessaoId());
        boolean isValidAssociado = associadoService.isValid(votoInput.getAssociadoId());
        boolean isAssociadoAindaNaoVotou = Objects.isNull(findByAssociado(votoInput.getAssociadoId()));
        boolean isValorCorreto = isValorCorreto(votoInput);
        return isPautaExists && isValidSessao && isValidAssociado && isValorCorreto && isAssociadoAindaNaoVotou;
    }

    private Boolean isValorCorreto(VotoInputWrapper votoInput) {
        String valorVoto = votoInput.getValor().toUpperCase().trim();
        return valorVoto.equals(ValorVotoEnum.SIM.getValor()) || valorVoto.equals(ValorVotoEnum.NAO.getValor());
    }

    @Override
    public ContabilizacaoOutputWrapper getContabilizacao(List<Voto> votosValidos) {
        int votosSim = getQuantidadeVotos(votosValidos, ValorVotoEnum.SIM);
        int votosNao = getQuantidadeVotos(votosValidos, ValorVotoEnum.NAO);
        String resultado = getResultadoVotos(votosSim, votosNao);
        return ContabilizacaoOutputWrapper.builder()
                .votosSim(votosSim)
                .votosNao(votosNao)
                .resultado(resultado)
                .build();
    }

    public static int getQuantidadeVotos(List<Voto> votosValidos, ValorVotoEnum valor) {
        return (int) votosValidos.stream().filter(voto -> voto.getValor().toUpperCase().equals(valor.getValor())).count();
    }

    private static String getResultadoVotos(int votosSim, int votosNao) {
        String resultado;
        if (votosSim > votosNao) {
            resultado = PAUTA_APROVADA;
        } else if (votosSim < votosNao) {
            resultado = PAUTA_REPROVADA;
        } else {
            resultado = EMPATE_DE_VOTOS;
        }
        return resultado;
    }
}
