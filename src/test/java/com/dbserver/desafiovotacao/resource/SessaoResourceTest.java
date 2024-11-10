package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Sessao;
import com.dbserver.desafiovotacao.fixture.SessaoFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.SessaoInputWrapperFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.SessaoOutputWrapperFixture;
import com.dbserver.desafiovotacao.resource.mapper.SessaoMapper;
import com.dbserver.desafiovotacao.service.SessaoService;
import com.dbserver.desafiovotacao.service.input.SessaoInputWrapper;
import com.dbserver.desafiovotacao.service.output.SessaoOutputWrapper;
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
@WebMvcTest(SessaoResource.class)
class SessaoResourceTest {
    @MockBean
    SessaoService sessaoService;
    @MockBean
    SessaoMapper sessaoMapper;

    @Autowired
    MockMvc mockMvc;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void DeveIniciarSessao() throws Exception {
        Sessao sessao = SessaoFixture.getWithId(1);
        SessaoInputWrapper sessaoInputWrapper = SessaoInputWrapperFixture.get();
        SessaoOutputWrapper sessaoOutputWrapper = SessaoOutputWrapperFixture.get();
        Mockito.when(sessaoService.iniciar(any())).thenReturn(sessao);
        Mockito.when(sessaoMapper.toOutputWrapper(any())).thenReturn(sessaoOutputWrapper);

        mockMvc.perform(post("/api/v1/sessao")
                        .content(mapper.writeValueAsString(sessaoInputWrapper))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.sessaoId", Matchers.is(1)))
                .andExpect(jsonPath("$.prazoDuracao", Matchers.is(10)))
                .andExpect(jsonPath("$.pautaId", Matchers.is("1")));
    }

}