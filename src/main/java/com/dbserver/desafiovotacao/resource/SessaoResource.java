package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Sessao;
import com.dbserver.desafiovotacao.resource.mapper.SessaoMapper;
import com.dbserver.desafiovotacao.service.SessaoService;
import com.dbserver.desafiovotacao.service.input.SessaoInputWrapper;
import com.dbserver.desafiovotacao.service.output.SessaoOutputWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sessao")
@AllArgsConstructor
public class SessaoResource {

    private final SessaoService sessaoService;
    private final SessaoMapper sessaoMapper;

    @PostMapping
    ResponseEntity<SessaoOutputWrapper> iniciarSessao(@RequestBody SessaoInputWrapper inputWrapper){
        Sessao sessaoIniciada = sessaoService.iniciar(inputWrapper);
        return ResponseEntity.ok(sessaoMapper.toOutputWrapper(sessaoIniciada));
    }
}
