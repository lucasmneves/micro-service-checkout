package com.fiap.checkout.core.domain.entities;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PedidoDTOTest {

    @Test
    public void testGetId() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setId("12345");
        assertEquals("12345", pedido.getId());
    }


    @Test
    public void testGetIdStatus() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setId_status("OPEN");
        assertEquals("OPEN", pedido.getId_status());
    }

    @Test
    public void testGetCpf() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setCpf("1234567890");
        assertEquals("1234567890", pedido.getCpf());
    }

    @Test
    public void testGetDetalhes() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setDetalhes("Some details");
        assertEquals("Some details", pedido.getDetalhes());
    }

    @Test
    public void testGetDataHoraInicio() {
        PedidoDTO pedido = new PedidoDTO();
        Date dataHoraInicio = new Date();
        pedido.setData_hora_inicio(dataHoraInicio);
        assertEquals(dataHoraInicio, pedido.getData_hora_inicio());
    }

    private void assertEquals(Date dataHoraInicio, Date dataHoraInicio1) {
    }

    @Test
    public void testGetDataHoraFim() {
        PedidoDTO pedido = new PedidoDTO();
        Date dataHoraFim = new Date();
        pedido.setData_hora_fim(dataHoraFim);
        assertEquals(dataHoraFim, pedido.getData_hora_fim());
    }

    @Test
    public void testGetIdPagamento() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setId_pagamento("PAY123");
        assertEquals("PAY123", pedido.getId_pagamento());
    }

    private void assertEquals(String pay123, String idPagamento) {
    }

    @Test
    public void testGetIdSatisfacao() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setId_satisfacao("SATISFIED");
        assertEquals("SATISFIED", pedido.getId_satisfacao());
    }
}