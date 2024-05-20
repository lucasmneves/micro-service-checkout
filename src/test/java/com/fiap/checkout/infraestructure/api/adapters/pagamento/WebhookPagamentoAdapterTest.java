package com.fiap.checkout.infraestructure.api.adapters.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.WebhookPagamentoAdapter;
import com.fiap.checkout.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.checkout.infraestructure.persistence.repositories.PedidoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class WebhookPagamentoAdapterTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PagamentoMapper pagamentoMapper;

    @InjectMocks
    private WebhookPagamentoAdapter webhookPagamentoAdapter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void webhookPagamento_ExistingPedidoId_StatusUpdated() {
        // Arrange
        WebhookPagamentoResponse webhookPagamentoResponse = new WebhookPagamentoResponse();
        webhookPagamentoResponse.setIdPedido("1");
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId_status("1");
        Optional<PedidoEntity> pedidoOptional = Optional.of(pedidoEntity);
        when(pedidoRepository.findById("1")).thenReturn(pedidoOptional);

        // Act
        WebhookPagamentoResponse result = webhookPagamentoAdapter.webhookPagamento(webhookPagamentoResponse);

        // Assert
        assertEquals("4", pedidoEntity.getId_status());
        assertEquals(webhookPagamentoResponse, result);
        verify(pedidoRepository, times(1)).findById("1");
        verify(pedidoRepository, times(1)).save(pedidoEntity);
    }

    @Test
    public void webhookPagamento_NonExistingPedidoId_ExceptionThrown() {
        // Arrange
        WebhookPagamentoResponse webhookPagamentoResponse = new WebhookPagamentoResponse();
        webhookPagamentoResponse.setIdPedido("1");
        Optional<PedidoEntity> pedidoOptional = Optional.empty();
        when(pedidoRepository.findById("1")).thenReturn(pedidoOptional);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> webhookPagamentoAdapter.webhookPagamento(webhookPagamentoResponse));
        verify(pedidoRepository, times(1)).findById("1");
        verify(pedidoRepository, never()).save(any(PedidoEntity.class));
    }
}