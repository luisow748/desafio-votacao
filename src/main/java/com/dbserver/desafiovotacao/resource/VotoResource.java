package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.resource.mapper.VotoMapper;
import com.dbserver.desafiovotacao.service.VotoService;
import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;
import com.dbserver.desafiovotacao.service.output.ContabilizacaoOutputWrapper;
import com.dbserver.desafiovotacao.service.output.VotoOutputWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/voto")
@RequiredArgsConstructor
public class VotoResource {
    private final VotoService votoService;
    private final VotoMapper votoMapper;

    @PostMapping
    ResponseEntity<VotoOutputWrapper> save(@RequestBody VotoInputWrapper votoInputWrapper) {
        Voto votoSalvo = votoService.save(votoInputWrapper);
        return ResponseEntity.ok(votoMapper.toOutputWrapper(votoSalvo));
    }

    @GetMapping("{sessaoId}")
    ResponseEntity<ContabilizacaoOutputWrapper> getContabilizacao(@PathVariable Integer sessaoId) {
        var votosValidos = votoService.findBySessao(sessaoId);
        return ResponseEntity.ok(votoService.getContabilizacao(votosValidos));
    }
}
