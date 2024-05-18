package com.fiap.checkout.infraestructure.api.controller;

import com.fiap.checkout.core.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.checkout.core.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.checkout.core.ports.in.pagamento.ListarMeioPagamentoInputPort;
import com.fiap.checkout.core.ports.in.pagamento.WebhookPagamentoInputPort;
import com.fiap.checkout.infraestructure.api.controllers.PagamentoController;
import com.fiap.checkout.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.checkout.infraestructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import com.fiap.checkout.infraestructure.api.responses.EfetuarPagamentoResponse;
import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;
import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PagamentoControllerTest {

    @Mock
    private PagamentoMapper pagamentoMapper;
    @Mock
    private ListarMeioPagamentoInputPort listarMeiosPagamentosInputPort;
    @Mock
    private EfetuarPagamentoInputPort efetuarPagamentoInputPort;
    @Mock
    private ConsultarStatusPagamentoInputPort consultarStatusPagamentoInputPort;
    @Mock
    private WebhookPagamentoInputPort webhookPagamentoInputPort;

    private PagamentoController pagamentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pagamentoController = new PagamentoController(
                pagamentoMapper,
                listarMeiosPagamentosInputPort,
                efetuarPagamentoInputPort,
                consultarStatusPagamentoInputPort,
                webhookPagamentoInputPort
        );
    }

    @Test
    void listarMeiosPagamentos_ShouldReturnListOfPagamentoResponse() {

        List<PagamentoResponse> expectedPagamentos = new ArrayList<>();
        when(listarMeiosPagamentosInputPort.listaMeio()).thenReturn(expectedPagamentos);

        List<PagamentoResponse> actualPagamentos = pagamentoController.listarMeiosPagamentos();

        assertEquals(expectedPagamentos, actualPagamentos);
        verify(listarMeiosPagamentosInputPort, times(1)).listaMeio();
    }

    @Test
    void efetuarPagamento_ShouldReturnOkResponseWithEfetuarPagamentoResponse() {

        EfetuarPagamentoRequest efetuarPagamentoRequest = new EfetuarPagamentoRequest();
        EfetuarPagamentoResponse expectedPagamento = new EfetuarPagamentoResponse();
        when(pagamentoMapper.toEfetuarPagamentoResponse(efetuarPagamentoRequest)).thenReturn(expectedPagamento);

        ResponseEntity<EfetuarPagamentoResponse> response = pagamentoController.efetuarPagamento(efetuarPagamentoRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPagamento, response.getBody());
        verify(pagamentoMapper, times(1)).toEfetuarPagamentoResponse(efetuarPagamentoRequest);
        verify(efetuarPagamentoInputPort, times(1)).efetuarPagamento(expectedPagamento);
    }

    @Test
    void webhookPagamento_ShouldReturnOkResponseWithWebhookPagamentoResponse() {
        String id = "123";
        WebhookPagamentoResponse expectedWebhookPagamento = new WebhookPagamentoResponse();
        when(webhookPagamentoInputPort.webhookPagamento(any(WebhookPagamentoResponse.class))).thenReturn(expectedWebhookPagamento);

        ResponseEntity<WebhookPagamentoResponse> response = pagamentoController.webhookPagamento(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedWebhookPagamento, response.getBody());
        verify(webhookPagamentoInputPort, times(1)).webhookPagamento(any(WebhookPagamentoResponse.class));
    }

    @Test
    void consultarStatusPagamento_ShouldReturnOkResponseWithConsultarStatusPagamentoResponse() {
        String id = "123";
        ConsultarStatusPagamentoResponse expectedConsultarStatusPagamento = new ConsultarStatusPagamentoResponse();
        when(consultarStatusPagamentoInputPort.consultarStatusPagamento(any(ConsultarStatusPagamentoResponse.class))).thenReturn(expectedConsultarStatusPagamento);

        ResponseEntity<ConsultarStatusPagamentoResponse> response = pagamentoController.consultarStatusPagamento(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedConsultarStatusPagamento, response.getBody());
        verify(consultarStatusPagamentoInputPort, times(1)).consultarStatusPagamento(any(ConsultarStatusPagamentoResponse.class));
    }
}