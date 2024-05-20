package com.fiap.checkout.infraestructure.api.persistence.entities;


import com.fiap.checkout.infraestructure.persistence.entities.ItensPedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItensPedidoEntityTest {

	private ItensPedidoEntity itensPedidoEntity;
	private com.fiap.checkout.infraestructure.persistence.entities.ProdutoEntity produtoEntity;
	private com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity pedidoEntity;

	@BeforeEach
	public void setUp() {
		itensPedidoEntity = new ItensPedidoEntity();
		produtoEntity = new com.fiap.checkout.infraestructure.persistence.entities.ProdutoEntity();
		pedidoEntity = new com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity();
	}

	@Test
	public void testGetId() {
		String id = "123";
		itensPedidoEntity.setId(id);
		assertEquals(id, itensPedidoEntity.getId());
	}

	@Test
	public void testGetProduto() {
		itensPedidoEntity.setProduto(produtoEntity);
		assertEquals(produtoEntity, itensPedidoEntity.getProduto());
	}

	@Test
	public void testGetPedido() {
		itensPedidoEntity.setPedido(pedidoEntity);
		assertEquals(pedidoEntity, itensPedidoEntity.getPedido());
	}
}