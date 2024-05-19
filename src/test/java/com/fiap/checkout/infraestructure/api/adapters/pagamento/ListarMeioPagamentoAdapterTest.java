package com.fiap.checkout.infraestructure.api.adapters.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.ListarMeioPagamentoAdapter;
import com.fiap.checkout.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListarMeioPagamentoAdapterTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @Mock
    private PagamentoMapper pagamentoMapper;

    @InjectMocks
    private ListarMeioPagamentoAdapter listarMeioPagamentoAdapter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListaMeio() {
        // Arrange
        List<PagamentoEntity> pagamentoEntities = new ArrayList<>();
        pagamentoEntities.add(new PagamentoEntity());
        pagamentoEntities.add(new PagamentoEntity());

        List<PagamentoResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(new PagamentoResponse());
        expectedResponses.add(new PagamentoResponse());

        when(pagamentoRepository.findAll()).thenReturn(pagamentoEntities);
        when(pagamentoMapper.toListaPagamentoResponse(pagamentoEntities)).thenReturn(expectedResponses);

        // Act
        List<PagamentoResponse> actualResponses = listarMeioPagamentoAdapter.listaMeio();

        // Assert
        assertEquals(expectedResponses, actualResponses);
        verify(pagamentoRepository, times(1)).findAll();
        verify(pagamentoMapper, times(1)).toListaPagamentoResponse(pagamentoEntities);
    }

    @Test
    public void testListaMeioWithRemovedFirstElement() {
        // Arrange
        List<PagamentoEntity> pagamentoEntities = new ArrayList<>();
        pagamentoEntities.add(new PagamentoEntity());
        pagamentoEntities.add(new PagamentoEntity());

        List<PagamentoResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(new PagamentoResponse());

        when(pagamentoRepository.findAll()).thenReturn(pagamentoEntities);
        when(pagamentoMapper.toListaPagamentoResponse(pagamentoEntities)).thenReturn(expectedResponses);

        // Act
        List<PagamentoResponse> actualResponses = listarMeioPagamentoAdapter.listaMeio();

        // Assert
        assertEquals(expectedResponses, actualResponses);
        verify(pagamentoRepository, times(1)).findAll();
        verify(pagamentoMapper, times(1)).toListaPagamentoResponse(pagamentoEntities);
    }
}