package com.fiap.checkout.core.ports.in.pagamento;

import com.fiap.checkout.infraestructure.api.responses.EfetuarPagamentoResponse;

public interface EfetuarPagamentoInputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
