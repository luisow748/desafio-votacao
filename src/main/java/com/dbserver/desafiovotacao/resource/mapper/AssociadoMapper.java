package com.dbserver.desafiovotacao.resource.mapper;

import com.dbserver.desafiovotacao.domain.Associado;
import com.dbserver.desafiovotacao.service.input.AssociadoInputWrapper;
import com.dbserver.desafiovotacao.service.output.AssociadoOutputWrapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociadoMapper {
    Associado toEntity(AssociadoInputWrapper inputWrapper);
    AssociadoOutputWrapper toOutputWrapper(Associado associado);
}
