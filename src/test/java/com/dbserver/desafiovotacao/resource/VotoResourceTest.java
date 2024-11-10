package com.dbserver.desafiovotacao.resource;

import com.dbserver.desafiovotacao.domain.Voto;
import com.dbserver.desafiovotacao.domain.enums.ValorVotoEnum;
import com.dbserver.desafiovotacao.fixture.VotoFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.ContabilizacaoOutputWrapperFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.VotoInputWrapperFixture;
import com.dbserver.desafiovotacao.fixture.wrapper.VotoOutputWrapperFixture;
import com.dbserver.desafiovotacao.resource.mapper.VotoMapperImpl;
import com.dbserver.desafiovotacao.service.VotoService;
import com.dbserver.desafiovotacao.service.input.VotoInputWrapper;
import com.dbserver.desafiovotacao.service.output.VotoOutputWrapper;
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

import java.util.List;

import static com.dbserver.desafiovotacao.service.impl.VotoServiceImpl.PAUTA_APROVADA;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VotoResource.class)
class VotoResourceTest {

    @MockBean
    VotoService votoService;
    @MockBean
    VotoMapperImpl votoMapper;
    @Autowired
    MockMvc mockMvc;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void DeveSalvarVoto() throws Exception {
        VotoInputWrapper votoInputWrapper = VotoInputWrapperFixture.get(ValorVotoEnum.SIM.getValor());
        VotoOutputWrapper votoOutputWrapper = VotoOutputWrapperFixture.get(votoInputWrapper);
        Mockito.when(votoService.save(any())).thenReturn(VotoFixture.getFromInputWrapper(votoInputWrapper));
        Mockito.when(votoMapper.toOutputWrapper(any())).thenReturn(votoOutputWrapper);

        mockMvc.perform(post("/api/v1/voto")
                        .content(mapper.writeValueAsString(votoInputWrapper))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.votoId", Matchers.is(1)))
                .andExpect(jsonPath("$.valor", Matchers.is(ValorVotoEnum.SIM.getValor())))
                .andExpect(jsonPath("$.sessaoId", Matchers.is(1)))
                .andExpect(jsonPath("$.pautaId", Matchers.is(1)));

    }

    @Test
    void DeveRetornarContabilizacao() throws Exception {
        List<Voto> listAprovados = VotoFixture.getListAprovados();
        Mockito.when(votoService.findBySessao(any())).thenReturn(listAprovados);
        Mockito.when(votoService.getContabilizacao(any()))
                .thenReturn(ContabilizacaoOutputWrapperFixture.getFromListVotos(listAprovados));

        mockMvc.perform(get("/api/v1/voto/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.votosSim", Matchers.is(3)))
                .andExpect(jsonPath("$.votosNao", Matchers.is(1)))
                .andExpect(jsonPath("$.resultado", Matchers.is(PAUTA_APROVADA)));
    }


}