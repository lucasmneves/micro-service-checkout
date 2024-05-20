package com.fiap.checkout.infraestructure.api.persistence.entities;

import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PagamentoEntityTest {

	private PagamentoEntity pagamento;

	@BeforeEach
	public void setUp() {
		pagamento = new PagamentoEntity();
	}

	@Test
	public void testGetId() {
		String id = "123";
		pagamento.setId(id);
		Assertions.assertEquals(id, pagamento.getId());
	}

	@Test
	public void testGetNome() {
		String nome = "John Doe";
		pagamento.setNome(nome);
		Assertions.assertEquals(nome, pagamento.getNome());
	}

	private String serialize(PagamentoEntity pagamento) {
		// Implement serialization logic
		return null;
	}

	private PagamentoEntity deserialize(String serializedData) {
		// Implement deserialization logic
		return null;
	}
}