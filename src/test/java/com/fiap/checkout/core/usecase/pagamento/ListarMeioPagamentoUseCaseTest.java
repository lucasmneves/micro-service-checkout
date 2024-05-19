package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.core.ports.out.pagamento.ListarMeioPagamentoOutputPort;
import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListarMeioPagamentoUseCaseTest {

    @Mock
    private ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort;

    private ListarMeioPagamentoUseCase listarMeioPagamentoUseCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        listarMeioPagamentoUseCase = new ListarMeioPagamentoUseCase(listarMeioPagamentoOutputPort);
    }

    @Test
    public void testListaMeio_PagamentoResponse() {
        List<PagamentoResponse> expectedList = new ArrayList<>();
        expectedList.add(new PagamentoResponse());
        expectedList.add(new PagamentoResponse());
        when(listarMeioPagamentoOutputPort.listaMeio()).thenReturn(expectedList);

        List<PagamentoResponse> actualList = listarMeioPagamentoUseCase.listaMeio();

        assertEquals(expectedList, actualList);
        verify(listarMeioPagamentoOutputPort, times(1)).listaMeio();
    }

    @Test
    public void testListaMeio_ListaVazia_PagamentoResponse() {
        List<PagamentoResponse> expectedList = new ArrayList<>();
        when(listarMeioPagamentoOutputPort.listaMeio()).thenReturn(expectedList);

        List<PagamentoResponse> actualList = listarMeioPagamentoUseCase.listaMeio();

        assertEquals(expectedList, actualList);
        verify(listarMeioPagamentoOutputPort, times(1)).listaMeio();
    }

    @Test
    public void testListaMeio_RetornaNull_OutputPortReturnsNull() {

        when(listarMeioPagamentoOutputPort.listaMeio()).thenReturn(null);

        List<PagamentoResponse> actualList = listarMeioPagamentoUseCase.listaMeio();

        assertEquals(null, actualList);
        verify(listarMeioPagamentoOutputPort, times(1)).listaMeio();
    }
}