package com.dbserver.desafiovotacao.resource.mapper;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.service.output.VotoOutputWrapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface VotoMapper {

    @Mapping(source = "sessao.sessaoId", target = "sessaoId")
    @Mapping(source = "pauta.pautaId", target = "pautaId")
    VotoOutputWrapper toOutputWrapper(Voto voto);
}
