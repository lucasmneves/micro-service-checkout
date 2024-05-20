package com.fiap.checkout.infraestructure.api.persistence.entities;

import com.fiap.checkout.infraestructure.persistence.entities.StatusEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatusEntityTest {

	private StatusEntity statusEntity;

	@BeforeEach
	public void setUp() {
		statusEntity = new StatusEntity();
	}

	@Test
	public void testGetId() {
		String id = "123";
		statusEntity.setId(id);
		Assertions.assertEquals(id, statusEntity.getId());
	}

	@Test
	public void testGetDescricao() {
		String descricao = "Test Description";
		statusEntity.setDescricao(descricao);
		Assertions.assertEquals(descricao, statusEntity.getDescricao());
	}

	@Test
	public void testNotEquals() {
		StatusEntity statusEntity1 = new StatusEntity();
		statusEntity1.setId("123");
		statusEntity1.setDescricao("Test Description");

		StatusEntity statusEntity2 = new StatusEntity();
		statusEntity2.setId("456");
		statusEntity2.setDescricao("Different Description");

		Assertions.assertNotEquals(statusEntity1, statusEntity2);
	}
}