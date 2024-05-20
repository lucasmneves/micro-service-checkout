package com.fiap.checkout.infraestructure.api.persistence.entities;

import com.fiap.checkout.infraestructure.persistence.entities.SatisfacaoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SatisfacaoEntityTest {

	private SatisfacaoEntity satisfacaoEntity;

	@BeforeEach
	public void setUp() {
		satisfacaoEntity = new SatisfacaoEntity();
	}

	@Test
	public void testGetId() {
		String id = "123";
		satisfacaoEntity.setId(id);
		assertEquals(id, satisfacaoEntity.getId());
	}

	@Test
	public void testGetNome() {
		String nome = "John Doe";
		satisfacaoEntity.setNome(nome);
		assertEquals(nome, satisfacaoEntity.getNome());
	}

	@Test
	public void testSetId() {
		String id = "123";
		satisfacaoEntity.setId(id);
		assertEquals(id, satisfacaoEntity.getId());
	}

	@Test
	public void testSetNome() {
		String nome = "John Doe";
		satisfacaoEntity.setNome(nome);
		assertEquals(nome, satisfacaoEntity.getNome());
	}
}