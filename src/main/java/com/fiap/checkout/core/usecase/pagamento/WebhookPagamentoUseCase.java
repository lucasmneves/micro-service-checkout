package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.core.ports.in.pagamento.WebhookPagamentoInputPort;
import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;
import com.fiap.checkout.application.ports.out.pagamento.WebhookPagamentoOutputPort;

public class WebhookPagamentoUseCase implements WebhookPagamentoInputPort {
    private final WebhookPagamentoOutputPort webhookPagamentoOutputPort;
    public WebhookPagamentoUseCase(WebhookPagamentoOutputPort webhookPagamentoOutputPort) {
        this.webhookPagamentoOutputPort = webhookPagamentoOutputPort;
    }
    @Override
    public WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse) {
        webhookPagamentoResponse.setStatus("Pagamento confirmado!");
        return this.webhookPagamentoOutputPort.webhookPagamento(webhookPagamentoResponse);
    }
}

