package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;
import org.junit.Before;
import org.junit.Test;
import com.fiap.checkout.application.ports.out.pagamento.WebhookPagamentoOutputPort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class WebhookPagamentoUseCaseTest {
    private WebhookPagamentoOutputPort outputPort;
    private WebhookPagamentoUseCase useCase;

    @Before
    public void setUp() {
        outputPort = mock(WebhookPagamentoOutputPort.class);
        useCase = new WebhookPagamentoUseCase(outputPort);
    }

    @Test
    public void webhookPagamento_WithValidResponse_ShouldSetStatusAndCallOutputPort() {

        WebhookPagamentoResponse response = new WebhookPagamentoResponse();

        WebhookPagamentoResponse result = useCase.webhookPagamento(response);

        assertEquals("Pagamento confirmado!", response.getStatus());
        verify(outputPort, times(1)).webhookPagamento(response);
        assertEquals(result, response);
    }

    @Test
    public void webhookPagamento_WithNullResponse_ShouldThrowException() {

        WebhookPagamentoResponse response = null;

        assertThrows(NullPointerException.class, () -> useCase.webhookPagamento(response));
    }

    @Test
    public void webhookPagamento_WithEmptyStatus_ShouldSetStatusAndCallOutputPort() {

        WebhookPagamentoResponse response = new WebhookPagamentoResponse();
        response.setStatus("");

        WebhookPagamentoResponse result = useCase.webhookPagamento(response);

        assertEquals("Pagamento confirmado!", response.getStatus());
        verify(outputPort, times(1)).webhookPagamento(response);
        assertEquals(result, response);
    }

    @Test
    public void webhookPagamento_WithExistingStatus_ShouldNotChangeStatusAndCallOutputPort() {

        WebhookPagamentoResponse response = new WebhookPagamentoResponse();
        response.setStatus("Existing status");

        WebhookPagamentoResponse result = useCase.webhookPagamento(response);

        assertEquals("Existing status", response.getStatus());
        verify(outputPort, times(1)).webhookPagamento(response);
        assertEquals(result, response);
    }
}