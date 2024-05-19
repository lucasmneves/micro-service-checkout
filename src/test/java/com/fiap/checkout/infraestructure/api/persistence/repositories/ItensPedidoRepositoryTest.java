/*package com.fiap.checkout.infraestructure.api.controller.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.ItensPedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ItensPedidoRepositoryTest {

    @Mock
    private JpaRepository<ItensPedidoEntity, String> jpaRepository;

    @InjectMocks
    private ItensPedidoRepositoryTestImpl itensPedidoRepositoryTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuscarProdutoEPedido() {
        String produto = "123";
        String pedido = "456";
        List<ItensPedidoEntity> expectedEntities = new ArrayList<>();
        expectedEntities.add(new ItensPedidoEntity());

        when(jpaRepository.buscarProdutoEPedido(produto, pedido)).thenReturn(expectedEntities);

        List<ItensPedidoEntity> actualEntities = itensPedidoRepositoryTest.buscarProdutoEPedido(produto, pedido);

        assertEquals(expectedEntities, actualEntities);
    }

    @Test
    public void testBuscarItensPedidoPorId() {
        String pedido = "456";
        List<ItensPedidoEntity> expectedEntities = new ArrayList<>();
        expectedEntities.add(new ItensPedidoEntity());

        when(jpaRepository.buscarItensPedidoPorId(pedido)).thenReturn(expectedEntities);

        List<ItensPedidoEntity> actualEntities = itensPedidoRepositoryTest.buscarItensPedidoPorId(pedido);

        assertEquals(expectedEntities, actualEntities);
    }
}

class ItensPedidoRepositoryTestImpl extends ItensPedidoRepositoryTest {

}*/