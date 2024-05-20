package com.fiap.checkout.core.ports.in.pagamento;

import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;

import java.util.List;

public interface ListarMeioPagamentoInputPort {
    List<PagamentoResponse> listaMeio();
}
