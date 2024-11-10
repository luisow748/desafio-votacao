package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Associado;
import com.dbserver.desafiovotacao.resource.mapper.AssociadoMapper;
import com.dbserver.desafiovotacao.service.AssociadoService;
import com.dbserver.desafiovotacao.service.input.AssociadoInputWrapper;
import com.dbserver.desafiovotacao.service.output.AssociadoOutputWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/associado")
@RequiredArgsConstructor
public class AssociadoResource {
    private final AssociadoMapper associadoMapper;
    private final AssociadoService associadoService;

    @PostMapping
    ResponseEntity<AssociadoOutputWrapper> save(@RequestBody AssociadoInputWrapper associadoInputWrapper) {
        Associado associadoRecebido = associadoMapper.toEntity(associadoInputWrapper);
        Associado associadoSalvo = associadoService.save(associadoRecebido);
        return ResponseEntity.ok(associadoMapper.toOutputWrapper(associadoSalvo));
    }
}
