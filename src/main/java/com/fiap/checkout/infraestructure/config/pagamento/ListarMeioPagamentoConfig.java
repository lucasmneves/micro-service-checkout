package com.fiap.checkout.infraestructure.config.pagamento;

import com.fiap.checkout.infraestructure.adapters.pagamento.ListarMeioPagamentoAdapter;
import com.fiap.checkout.core.usecase.pagamento.ListarMeioPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarMeioPagamentoConfig {

    @Bean
    public ListarMeioPagamentoUseCase listarMeioPagamentoUseCase(ListarMeioPagamentoAdapter listarMeioPagamentoAdapter){
        return new ListarMeioPagamentoUseCase(listarMeioPagamentoAdapter);
    };

}
