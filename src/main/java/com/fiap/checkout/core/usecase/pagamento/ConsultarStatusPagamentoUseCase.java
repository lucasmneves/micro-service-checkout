package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import com.fiap.checkout.core.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.checkout.core.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;

public class ConsultarStatusPagamentoUseCase implements ConsultarStatusPagamentoInputPort {
    private final ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort;
    public ConsultarStatusPagamentoUseCase(ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort) {
        this.consultarStatusPagamentoOutputPort = consultarStatusPagamentoOutputPort;
    }
    @Override
    public ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse) {

        return this.consultarStatusPagamentoOutputPort.consultarStatusPagamento(consultarStatusPagamentoResponse);
    }
}

