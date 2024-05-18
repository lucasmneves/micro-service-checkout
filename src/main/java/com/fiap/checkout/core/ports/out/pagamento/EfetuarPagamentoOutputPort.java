package com.fiap.checkout.core.ports.out.pagamento;

import com.fiap.checkout.infraestructure.api.responses.EfetuarPagamentoResponse;

public interface EfetuarPagamentoOutputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
