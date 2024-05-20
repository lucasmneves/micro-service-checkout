package com.fiap.checkout.core.ports.out.pagamento;

import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;

public interface ConsultarStatusPagamentoOutputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamento);
}
