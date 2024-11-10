package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Associado;
import com.dbserver.desafiovotacao.fixture.AssociadoFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.AssociadoInputWrapperFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.AssociadoOutputWrapperFixture;
import com.dbserver.desafiovotacao.resource.mapper.AssociadoMapper;
import com.dbserver.desafiovotacao.service.AssociadoService;
import com.dbserver.desafiovotacao.service.input.AssociadoInputWrapper;
import com.dbserver.desafiovotacao.service.output.AssociadoOutputWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AssociadoResource.class)
class AssociadoResourceTest {
    @MockBean
    AssociadoMapper associadoMapper;
    @MockBean
    AssociadoService associadoService;
    @Autowired
    MockMvc mockMvc;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void DeveSalvarAssociado() throws Exception {
        Associado associado = AssociadoFixture.get();
        AssociadoOutputWrapper associadoOutputWrapper = AssociadoOutputWrapperFixture.get();
        AssociadoInputWrapper associadoInputWrapper = AssociadoInputWrapperFixture.get();
        Mockito.when(associadoMapper.toEntity(any())).thenReturn(associado);
        Mockito.when(associadoService.save(any())).thenReturn(associado);
        Mockito.when(associadoMapper.toOutputWrapper(any())).thenReturn(associadoOutputWrapper);


        mockMvc.perform(post("/api/v1/associado")
                        .content(mapper.writeValueAsString(associadoInputWrapper))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.associadoId", Matchers.is(1)))
                .andExpect(jsonPath("$.nome", Matchers.is("Associado")));

    }

}