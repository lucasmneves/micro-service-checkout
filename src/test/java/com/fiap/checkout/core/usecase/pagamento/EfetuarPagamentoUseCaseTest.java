package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.core.ports.out.pagamento.EfetuarPagamentoOutputPort;
import com.fiap.checkout.core.usecase.pagamento.EfetuarPagamentoUseCase;
import com.fiap.checkout.infraestructure.api.responses.EfetuarPagamentoResponse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EfetuarPagamentoUseCaseTest {
    private EfetuarPagamentoOutputPortMock outputPortMock;
    private EfetuarPagamentoUseCase useCase;
    private EfetuarPagamentoResponse response;

    @Before
    public void setUp() {
        outputPortMock = new EfetuarPagamentoOutputPortMock();
        useCase = new EfetuarPagamentoUseCase(outputPortMock);
        response = new EfetuarPagamentoResponse();
    }

    @Test
    public void efetuarPagamento_SetStatusToPendente() {
        useCase.efetuarPagamento(response);
        assertEquals("Pendente", response.getStatus());
    }

    @Test
    public void efetuarPagamento_SetQrCode() {
        useCase.efetuarPagamento(response);
        assertNotNull(response.getQrCode());
        assertTrue(response.getQrCode().startsWith("0000028930293029309COM.MERCADOLIBRE"));
        assertTrue(response.getQrCode().endsWith("Testing21983xx12382718"));
    }

    @Test
    public void efetuarPagamento_SetUrlWebhook() {
        response.setIdPedido("123456");
        useCase.efetuarPagamento(response);
        assertEquals("localhost:8080/pagamento/123456", response.getUrlWebhook());
    }

    @Test
    public void efetuarPagamento_EfetuarPagamentoOnOutputPort() {
        useCase.efetuarPagamento(response);
        assertTrue(outputPortMock.isEfetuarPagamentoCalled());
        assertSame(response, outputPortMock.getEfetuarPagamentoResponse());
    }

    private static class EfetuarPagamentoOutputPortMock implements EfetuarPagamentoOutputPort {
        private boolean efetuarPagamentoCalled;
        private EfetuarPagamentoResponse efetuarPagamentoResponse;

        @Override
        public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse response) {
            efetuarPagamentoCalled = true;
            efetuarPagamentoResponse = response;
            return response;
        }

        public boolean isEfetuarPagamentoCalled() {
            return efetuarPagamentoCalled;
        }

        public EfetuarPagamentoResponse getEfetuarPagamentoResponse() {
            return efetuarPagamentoResponse;
        }
    }
}