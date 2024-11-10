package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Pauta;
import com.dbserver.desafiovotacao.resource.mapper.PautaMapper;
import com.dbserver.desafiovotacao.service.PautaService;
import com.dbserver.desafiovotacao.service.input.PautaInputWrapper;
import com.dbserver.desafiovotacao.service.output.PautaOutputWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pauta")
@AllArgsConstructor
public class PautaResource {
    private final PautaService pautaService;
    private final PautaMapper pautaMapper;

    @PostMapping
    ResponseEntity<PautaOutputWrapper> save(@RequestBody PautaInputWrapper pautaInput) {
        Pauta pautaSalva = pautaService.save(pautaMapper.toEntity(pautaInput));
        return ResponseEntity.ok(pautaMapper.toOutputWrapper(pautaSalva));
    }
}
