package com.fiap.checkout.infraestructure.config.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.EfetuarPagamentoAdapter;
import com.fiap.checkout.core.usecase.pagamento.EfetuarPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EfetuarPagamentoConfig {
    @Bean
    public EfetuarPagamentoUseCase EfetuarPagamentoUseCase(EfetuarPagamentoAdapter efetuarPagamentoAdapter){
        return new EfetuarPagamentoUseCase(efetuarPagamentoAdapter);
    };
}


