package com.fiap.checkout.infraestructure.api.adapters.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.EfetuarPagamentoAdapter;
import com.fiap.checkout.infraestructure.api.responses.EfetuarPagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.checkout.infraestructure.persistence.repositories.PedidoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EfetuarPagamentoAdapterTest {

    @Mock
    private PagamentoRepository pagamentoRepository;
    @Mock
    private PedidoRepository pedidoRepository;

    private EfetuarPagamentoAdapter efetuarPagamentoAdapterTest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        efetuarPagamentoAdapterTest = new EfetuarPagamentoAdapter(pagamentoRepository, pedidoRepository);
    }

    @Test
    public void efetuarPagamento_ValidData_ReturnsEfetuarPagamentoResponse() {
        BigDecimal valorTotal = new BigDecimal(100.0);
        // Arrange
        EfetuarPagamentoResponse efetuarPagamentoResponse = new EfetuarPagamentoResponse();
        efetuarPagamentoResponse.setIdPedido("1");

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setId("3");
        pagamentoEntity.setNome("Mercado Pago");
        when(pagamentoRepository.findById("3")).thenReturn(Optional.of(pagamentoEntity));

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId("1");
        pedidoEntity.setValor_total(valorTotal);
        when(pedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));

        // Act
        EfetuarPagamentoResponse result = efetuarPagamentoAdapterTest.efetuarPagamento(efetuarPagamentoResponse);

        // Assert

        assertNotNull(result);
        assertEquals("Mercado Pago", result.getTipoPagamento());

        verify(pedidoRepository, times(1)).save(pedidoEntity);
    }

    @Test(expected = RuntimeException.class)
    public void efetuarPagamento_PedidoNotFound_ThrowsRuntimeException() {
        // Arrange
        EfetuarPagamentoResponse efetuarPagamentoResponse = new EfetuarPagamentoResponse();
        efetuarPagamentoResponse.setIdPedido("1");

        when(pedidoRepository.findById("1")).thenReturn(Optional.empty());

        // Act
        efetuarPagamentoAdapterTest.efetuarPagamento(efetuarPagamentoResponse);

        // Assert
        // RuntimeException is expected to be thrown
    }
}