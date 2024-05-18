package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.core.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;
import com.fiap.checkout.core.usecase.pagamento.ConsultarStatusPagamentoUseCase;
import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ConsultarStatusPagamentoUseCaseTest {
    private ConsultarStatusPagamentoOutputPort outputPort;
    private ConsultarStatusPagamentoUseCase useCase;

    @Before
    public void setUp() {
        outputPort = mock(ConsultarStatusPagamentoOutputPort.class);
        useCase = new ConsultarStatusPagamentoUseCase(outputPort);
    }

    @Test
    public void consultarStatusPagamento_ValidResponse_ReturnsSameResponse() {

        ConsultarStatusPagamentoResponse inputResponse = new ConsultarStatusPagamentoResponse();
        when(outputPort.consultarStatusPagamento(inputResponse)).thenReturn(inputResponse);

        ConsultarStatusPagamentoResponse result = useCase.consultarStatusPagamento(inputResponse);

        assertEquals(inputResponse, result);
        verify(outputPort, times(1)).consultarStatusPagamento(inputResponse);
    }

    @Test
    public void consultarStatusPagamento_NullResponse_ReturnsNull() {

        ConsultarStatusPagamentoResponse inputResponse = null;

        ConsultarStatusPagamentoResponse result = useCase.consultarStatusPagamento(inputResponse);

        assertNull(result);
        verify(outputPort, never()).consultarStatusPagamento(any());
    }

    @Test
    public void consultarStatusPagamento_OutputPortReturnsDifferentResponse_ReturnsOutputPortResponse() {

        ConsultarStatusPagamentoResponse inputResponse = new ConsultarStatusPagamentoResponse();
        ConsultarStatusPagamentoResponse outputResponse = new ConsultarStatusPagamentoResponse();
        when(outputPort.consultarStatusPagamento(inputResponse)).thenReturn(outputResponse);

        ConsultarStatusPagamentoResponse result = useCase.consultarStatusPagamento(inputResponse);

        assertEquals(outputResponse, result);
        verify(outputPort, times(1)).consultarStatusPagamento(inputResponse);
    }
}