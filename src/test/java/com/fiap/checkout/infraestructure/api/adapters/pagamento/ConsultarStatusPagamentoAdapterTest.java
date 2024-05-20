package com.fiap.checkout.infraestructure.api.adapters.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.ConsultarStatusPagamentoAdapter;
import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.checkout.infraestructure.persistence.repositories.PedidoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsultarStatusPagamentoAdapterTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    private ConsultarStatusPagamentoAdapter consultarStatusPagamento;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        consultarStatusPagamento = new ConsultarStatusPagamentoAdapter(pagamentoRepository, pedidoRepository);
    }

    @Test
    public void testConsultarStatusPagamento_PedidoExistsAndStatusConfirmed() {
        // Arrange
        ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse = new ConsultarStatusPagamentoResponse();
        consultarStatusPagamentoResponse.setIdPedido("1");
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId_status("4");
        pedidoEntity.setSenha(123);
        when(pedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));
        when(pagamentoRepository.findById("3")).thenReturn(Optional.of(new PagamentoEntity()));

        // Act
        ConsultarStatusPagamentoResponse result = consultarStatusPagamento.consultarStatusPagamento(consultarStatusPagamentoResponse);
        result.setTipoPagamento("Mercado Pago");

        // Assert
        assertEquals("Mercado Pago", result.getTipoPagamento());
        assertEquals("Confirmado", result.getStatus());
        assertEquals("Pagamento confirmado!", result.getMensagem());
    }

    @Test
    public void testConsultarStatusPagamento() {
        // Arrange
        ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse = new ConsultarStatusPagamentoResponse();
        consultarStatusPagamentoResponse.setIdPedido("2");
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId_status("3");
        pedidoEntity.setSenha(123);
        when(pedidoRepository.findById("2")).thenReturn(Optional.of(pedidoEntity));
        when(pagamentoRepository.findById("3")).thenReturn(Optional.of(new PagamentoEntity()));

        // Act
        ConsultarStatusPagamentoResponse result = consultarStatusPagamento.consultarStatusPagamento(consultarStatusPagamentoResponse);
        result.setTipoPagamento("Mercado Pago");

        // Assert
        assertEquals("Mercado Pago", result.getTipoPagamento());
        assertEquals("Pendente", result.getStatus());
        assertEquals("Aguardando pagamento", result.getMensagem());
    }

    @Test(expected = RuntimeException.class)
    public void testConsultarStatusPagamento_PedidoNotFound() {
        // Arrange
        ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse = new ConsultarStatusPagamentoResponse();
        consultarStatusPagamentoResponse.setIdPedido("3");
        when(pedidoRepository.findById("3")).thenReturn(Optional.empty());

        // Act
        consultarStatusPagamento.consultarStatusPagamento(consultarStatusPagamentoResponse);

        // Assert (expected exception)
    }
}