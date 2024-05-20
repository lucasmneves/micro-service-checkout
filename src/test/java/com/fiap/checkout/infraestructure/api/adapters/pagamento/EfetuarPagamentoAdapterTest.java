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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EfetuarPagamentoAdapterTest {

    @Mock
    private PagamentoRepository pagamentoRepository;
    @Mock
    private PedidoRepository pedidoRepository;

    private EfetuarPagamentoAdapter efetuarPagamentoAdapter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        efetuarPagamentoAdapter = new EfetuarPagamentoAdapter(pagamentoRepository, pedidoRepository);
    }

    @Test
    public void efetuarPagamento_ValidInput_ReturnsEfetuarPagamentoResponse() {
        BigDecimal valorTotal = new BigDecimal(100.0);
        EfetuarPagamentoResponse efetuarPagamentoResponse = new EfetuarPagamentoResponse();
        efetuarPagamentoResponse.setIdPedido("1");
        efetuarPagamentoResponse.setValor(valorTotal);

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setId("3");
        pagamentoEntity.setNome("Mercado Pago");

        when(pagamentoRepository.findById("3")).thenReturn(Optional.of(pagamentoEntity));

        EfetuarPagamentoResponse result = efetuarPagamentoAdapter.efetuarPagamento(efetuarPagamentoResponse);

        assertEquals(efetuarPagamentoResponse, result);
        assertEquals("Mercado Pago", result.getTipoPagamento());
        verify(pedidoRepository, times(1)).save(any(PedidoEntity.class));
    }
}