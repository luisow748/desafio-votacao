package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Pauta;
import com.dbserver.desafiovotacao.fixture.PautaFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.PautaInputWrapperFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.PautaOutputWrapperFixture;
import com.dbserver.desafiovotacao.resource.mapper.PautaMapperImpl;
import com.dbserver.desafiovotacao.service.PautaService;
import com.dbserver.desafiovotacao.service.input.PautaInputWrapper;
import com.dbserver.desafiovotacao.service.output.PautaOutputWrapper;
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
@WebMvcTest(PautaResource.class)
class PautaResourceTest {

    @MockBean
    PautaService pautaService;
    @MockBean
    PautaMapperImpl pautaMapper;
    @Autowired
    MockMvc mockMvc;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void DeveSalvarPauta() throws Exception {
        Pauta pauta = PautaFixture.get();
        PautaInputWrapper pautaInputWrapper = PautaInputWrapperFixture.get();
        PautaOutputWrapper pautaOutputWrapper = PautaOutputWrapperFixture.getFromPauta(pauta);
        Mockito.when(pautaService.save(any())).thenReturn(pauta);
        Mockito.when(pautaMapper.toEntity(pautaInputWrapper)).thenReturn(pauta);
        Mockito.when(pautaMapper.toOutputWrapper(any())).thenReturn(pautaOutputWrapper);

        mockMvc.perform(post("/api/v1/pauta")
                        .content(mapper.writeValueAsString(pautaInputWrapper))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.nome", Matchers.is("Pauta 1")))
                .andExpect(jsonPath("$.descricao", Matchers.is("Pauta descrição")))
                .andExpect(jsonPath("$.pautaId", Matchers.is(1)));
    }
}

