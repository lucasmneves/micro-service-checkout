package com.fiap.checkout.infraestructure.config.pagamento;

import com.fiap.checkout.core.usecase.pagamento.ConsultarStatusPagamentoUseCase;
import com.fiap.checkout.infraestructure.adapters.pagamento.ConsultarStatusPagamentoAdapter;
import com.fiap.checkout.infraestructure.config.pagamento.ConsultarStatusPagamentoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@SpringBootTest
class ConsultarStatusPagamentoConfigTest {

    @Configuration
    @Import(ConsultarStatusPagamentoConfig.class)
    static class TestConfig {
        @Bean
        public ConsultarStatusPagamentoAdapter consultarStatusPagamento() {
            return mock(ConsultarStatusPagamentoAdapter.class);
        }
    }
    @Autowired
    private ConsultarStatusPagamentoUseCase consultarStatusPagamentoUseCase;

    @Test
    public void testConsultarStatusPagamentoBean() {
        assertNotNull(consultarStatusPagamentoUseCase, "O bean ConsultarStatusPagamento deve ser criado");
    }
}