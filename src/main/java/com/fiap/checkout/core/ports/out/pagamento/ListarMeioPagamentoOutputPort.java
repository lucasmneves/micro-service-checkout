package com.fiap.checkout.core.ports.out.pagamento;

import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;

import java.util.List;

public interface ListarMeioPagamentoOutputPort {
    List<PagamentoResponse> listaMeio();
}
