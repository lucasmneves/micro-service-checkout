package com.fiap.checkout.infraestructure.config.pagamento;

import com.fiap.checkout.core.usecase.pagamento.WebhookPagamentoUseCase;
import com.fiap.checkout.infraestructure.adapters.pagamento.WebhookPagamentoAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebhookPagamentoConfig {
    @Bean
    public WebhookPagamentoUseCase webhookPagamentoUseCase(WebhookPagamentoAdapter webhookPagamentoAdapter){
        return new WebhookPagamentoUseCase(webhookPagamentoAdapter);
    };

}


