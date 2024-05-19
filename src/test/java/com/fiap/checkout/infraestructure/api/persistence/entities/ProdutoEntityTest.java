package com.fiap.checkout.infraestructure.api.persistence.entities;

import com.fiap.checkout.infraestructure.persistence.entities.ProdutoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoEntityTest {

	private ProdutoEntity produto;

	@BeforeEach
	public void setUp() {
		produto = new ProdutoEntity();
	}

	@Test
	public void testGetId() {
		String id = "123";
		produto.setId(id);
		Assertions.assertEquals(id, produto.getId());
	}

	@Test
	public void testGetNome() {
		String nome = "Product";
		produto.setNome(nome);
		Assertions.assertEquals(nome, produto.getNome());
	}

	@Test
	public void testGetDescricao() {
		String descricao = "Product description";
		produto.setDescricao(descricao);
		Assertions.assertEquals(descricao, produto.getDescricao());
	}

	@Test
	public void testGetUrlImagem() {
		String urlImagem = "https://example.com/image.jpg";
		produto.setUrl_imagem(urlImagem);
		Assertions.assertEquals(urlImagem, produto.getUrl_imagem());
	}

	@Test
	public void testGetPreco() {
		String preco = "10.99";
		produto.setPreco(preco);
		Assertions.assertEquals(preco, produto.getPreco());
	}

	@Test
	public void testGetIdCategoria() {
		String idCategoria = "456";
		produto.setId_categoria(idCategoria);
		Assertions.assertEquals(idCategoria, produto.getId_categoria());
	}

	@Test
	public void testNoArgsConstructor() {
		ProdutoEntity produto = new ProdutoEntity();
		Assertions.assertNotNull(produto);
	}

	@Test
	public void testAllArgsConstructor() {
		String id = "123";
		String nome = "Product";
		String descricao = "Product description";
		String urlImagem = "https://example.com/image.jpg";
		String preco = "10.99";
		String idCategoria = "456";

		ProdutoEntity produto = new ProdutoEntity(id, nome, descricao, urlImagem, preco, idCategoria);

		Assertions.assertEquals(id, produto.getId());
		Assertions.assertEquals(nome, produto.getNome());
		Assertions.assertEquals(descricao, produto.getDescricao());
		Assertions.assertEquals(urlImagem, produto.getUrl_imagem());
		Assertions.assertEquals(preco, produto.getPreco());
		Assertions.assertEquals(idCategoria, produto.getId_categoria());
	}
}