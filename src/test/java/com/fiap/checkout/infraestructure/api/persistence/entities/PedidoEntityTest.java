package com.fiap.checkout.infraestructure.api.persistence.entities;

import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class PedidoEntityTest {

	@Test
	public void testGettersAndSetters() {
		PedidoEntity pedido = new PedidoEntity();

		pedido.setId("123");
		pedido.setSenha(456);
		pedido.setId_status("OPEN");
		pedido.setCpf("1234567890");
		pedido.setDetalhes("Test details");
		pedido.setValor_total(BigDecimal.valueOf(100.50));
		pedido.setData_hora_inicio(new Date());
		pedido.setData_hora_fim(new Date());
		pedido.setId_pagamento("PAY123");
		pedido.setId_satisfacao("SAT123");

		Assertions.assertEquals("123", pedido.getId());
		Assertions.assertEquals(456, pedido.getSenha());
		Assertions.assertEquals("OPEN", pedido.getId_status());
		Assertions.assertEquals("1234567890", pedido.getCpf());
		Assertions.assertEquals("Test details", pedido.getDetalhes());
		Assertions.assertEquals(BigDecimal.valueOf(100.50), pedido.getValor_total());
		Assertions.assertNotNull(pedido.getData_hora_inicio());
		Assertions.assertNotNull(pedido.getData_hora_fim());
		Assertions.assertEquals("PAY123", pedido.getId_pagamento());
		Assertions.assertEquals("SAT123", pedido.getId_satisfacao());
	}
}