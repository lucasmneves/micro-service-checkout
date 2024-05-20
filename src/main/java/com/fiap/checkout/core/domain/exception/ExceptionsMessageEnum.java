package com.fiap.checkout.core.domain.exception;

public enum ExceptionsMessageEnum {

	PRODUTO_NAO_ENCONTRADO("Produto não encontrado!"),
	PEDIDO_NAO_ENCONTRADO("Pedido não encontrado!");
	
	private String value;
	
	private ExceptionsMessageEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}

}
