package com.fiap.checkout.infraestructure.api.controller.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
public class PedidoRepositoryTest {

    @Mock
    private JpaRepository<PedidoEntity, String> pedidoRepository;

    @Test
    public void testFindAll() {
        List<PedidoEntity> expectedPedidos = List.of(
        );
        Mockito.when(pedidoRepository.findAll()).thenReturn(expectedPedidos);

        List<PedidoEntity> actualPedidos = pedidoRepository.findAll();

        assertEquals(expectedPedidos.size(), actualPedidos.size());
        assertEquals(expectedPedidos, actualPedidos);
    }

    @Test
    public void testFindById() {

        String orderId = "1";
        PedidoEntity expectedPedido = new PedidoEntity();
        Mockito.when(pedidoRepository.findById(orderId)).thenReturn(Optional.of(expectedPedido));

        Optional<PedidoEntity> actualPedido = pedidoRepository.findById(orderId);

        assertTrue(actualPedido.isPresent());
        assertEquals(expectedPedido, actualPedido.get());
    }

    @Test
    public void testSave() {
        PedidoEntity pedidoToSave = new PedidoEntity();
        Mockito.when(pedidoRepository.save(pedidoToSave)).thenReturn(pedidoToSave);

        PedidoEntity savedPedido = pedidoRepository.save(pedidoToSave);

        assertNotNull(savedPedido);
        assertEquals(pedidoToSave, savedPedido);
    }

    @Test
    public void testDeleteById() {
        String orderId = "1";

        pedidoRepository.deleteById(orderId);

        Mockito.verify(pedidoRepository, Mockito.times(1)).deleteById(orderId);
    }
}