package com.fiap.checkout.core.ports.in.pagamento;

import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;

public interface WebhookPagamentoInputPort {
    WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse);
}
