package com.fiap.checkout.application.ports.out.pagamento;

import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;

public interface WebhookPagamentoOutputPort {
    WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamento);
}
