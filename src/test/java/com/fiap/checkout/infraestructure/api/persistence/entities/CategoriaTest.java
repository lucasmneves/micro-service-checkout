package com.fiap.checkout.infraestructure.api.persistence.entities;

import com.fiap.checkout.infraestructure.persistence.entities.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria();
    }

    @Test
    public void testGetId() {
        String id = "123";
        categoria.setId(id);
        assertEquals(id, categoria.getId());
    }

    @Test
    public void testGetNome() {
        String nome = "Categoria 1";
        categoria.setNome(nome);
        assertEquals(nome, categoria.getNome());
    }

    @Test
    public void testGetDescricao() {
        String descricao = "Descrição da categoria";
        categoria.setDescricao(descricao);
        assertEquals(descricao, categoria.getDescricao());
    }

    @Test
    public void testSetId() {
        String id = "456";
        categoria.setId(id);
        assertEquals(id, categoria.getId());
    }

    @Test
    public void testSetNome() {
        String nome = "Categoria 2";
        categoria.setNome(nome);
        assertEquals(nome, categoria.getNome());
    }

    @Test
    public void testSetDescricao() {
        String descricao = "Nova descrição";
        categoria.setDescricao(descricao);
        assertEquals(descricao, categoria.getDescricao());
    }
}