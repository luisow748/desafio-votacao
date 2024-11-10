package com.dbserver.desafiovotacao.resource.mapper;

import com.dbserver.desafiovotacao.domain.Pauta;
import com.dbserver.desafiovotacao.service.input.PautaInputWrapper;
import com.dbserver.desafiovotacao.service.output.PautaOutputWrapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PautaMapper {

    @Mapping(target = "pautaId", ignore = true)
    @Mapping(target = "sessao", ignore = true)
    Pauta toEntity(PautaInputWrapper pautaInputWrapper);


//    @Mapping(target = "sessao", ignore = true)
    PautaOutputWrapper toOutputWrapper(Pauta pauta);
}
