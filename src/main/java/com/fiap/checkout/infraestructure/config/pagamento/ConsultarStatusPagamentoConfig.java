package com.fiap.checkout.infraestructure.config.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.ConsultarStatusPagamentoAdapter;
import com.fiap.checkout.core.usecase.pagamento.ConsultarStatusPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConsultarStatusPagamentoConfig {
    @Bean
    public ConsultarStatusPagamentoUseCase consultarStatusPagamentoUseCase(ConsultarStatusPagamentoAdapter consultarStatusPagamentoAdapter){
        return new ConsultarStatusPagamentoUseCase(consultarStatusPagamentoAdapter);
    };

}


