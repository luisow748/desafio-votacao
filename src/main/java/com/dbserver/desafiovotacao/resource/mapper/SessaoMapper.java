package com.dbserver.desafiovotacao.resource.mapper;

import com.dbserver.desafiovotacao.domain.Sessao;
import com.dbserver.desafiovotacao.service.output.SessaoOutputWrapper;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface SessaoMapper {

    SessaoOutputWrapper toOutputWrapper(Sessao sessao);
}
