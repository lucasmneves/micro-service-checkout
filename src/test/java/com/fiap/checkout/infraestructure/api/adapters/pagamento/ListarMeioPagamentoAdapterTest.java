package com.fiap.checkout.infraestructure.api.adapters.pagamento;

import com.fiap.checkout.core.ports.out.pagamento.ListarMeioPagamentoOutputPort;
import com.fiap.checkout.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.checkout.infraestructure.api.responses.PagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarMeioPagamentoAdapterTest implements ListarMeioPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public List<PagamentoResponse> listaMeio() {

        List<PagamentoEntity> pagamento = pagamentoRepository.findAll();
        pagamento.remove(0);
        return pagamentoMapper.toListaPagamentoResponse(pagamento);

    }

}
