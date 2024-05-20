package com.fiap.checkout.infraestructure.config.pagamento;

import com.fiap.checkout.core.usecase.pagamento.EfetuarPagamentoUseCase;
import com.fiap.checkout.infraestructure.adapters.pagamento.EfetuarPagamentoAdapter;
import com.fiap.checkout.infraestructure.config.pagamento.EfetuarPagamentoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@SpringBootTest
class EfetuarPagamentoConfigTest {

    @Configuration
    @Import(EfetuarPagamentoConfig.class)
    static class TestConfig {
        @Bean
        public EfetuarPagamentoAdapter efetuarPagamento() {
            return mock(EfetuarPagamentoAdapter.class);
        }
    }
    @Autowired
    private EfetuarPagamentoUseCase efetuarPagamentoUseCase;

    @Test
    public void testEfetuarPagamentoBean() {
        assertNotNull(efetuarPagamentoUseCase, "O bean EfetuarPagamento deve ser criado");
    }
}