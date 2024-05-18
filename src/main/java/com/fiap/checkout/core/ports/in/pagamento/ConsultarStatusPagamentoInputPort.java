package com.fiap.checkout.core.ports.in.pagamento;

import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;

public interface ConsultarStatusPagamentoInputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse);
}
