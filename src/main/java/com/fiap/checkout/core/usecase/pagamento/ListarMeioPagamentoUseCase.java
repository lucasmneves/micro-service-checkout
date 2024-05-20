
package com.fiap.checkout.core.usecase.pagamento;

import com.fiap.checkout.core.ports.in.pagamento.ListarMeioPagamentoInputPort;
import com.fiap.checkout.core.ports.out.pagamento.ListarMeioPagamentoOutputPort;
import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;

import java.util.List;


public class ListarMeioPagamentoUseCase implements ListarMeioPagamentoInputPort {
    private final ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort;
    public ListarMeioPagamentoUseCase(ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort) {
        this.listarMeioPagamentoOutputPort = listarMeioPagamentoOutputPort;
    }
    @Override
    public List<PagamentoResponse> listaMeio() {
        return this.listarMeioPagamentoOutputPort.listaMeio();
    }
}

