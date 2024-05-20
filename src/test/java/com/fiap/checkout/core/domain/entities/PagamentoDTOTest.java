package com.fiap.checkout.core.domain.entities;

import org.junit.Test;
import static org.junit.Assert.*;

public class PagamentoDTOTest {

    @Test
    public void testGetId() {
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setId("12345");
        assertEquals("12345", pagamento.getId());
    }

    @Test
    public void testGetNome() {
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setNome("John Doe");
        assertEquals("John Doe", pagamento.getNome());
    }

    @Test
    public void testSetId() {
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setId("54321");
        assertEquals("54321", pagamento.getId());
    }

    @Test
    public void testSetNome() {
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setNome("Jane Smith");
        assertEquals("Jane Smith", pagamento.getNome());
    }

    @Test
    public void testSerialVersionUID() {
        assertEquals(1L, PagamentoDTO.getSerialVersionUID());
    }
}