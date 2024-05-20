package com.fiap.checkout.infraestructure.adapters.pagamento;

import com.fiap.checkout.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.checkout.infraestructure.api.responses.WebhookPagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.checkout.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.application.ports.out.pagamento.WebhookPagamentoOutputPort;
import com.fiap.checkout.core.domain.exception.ExceptionsMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WebhookPagamentoAdapter implements WebhookPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse) {

        Optional<PedidoEntity> pedido = pedidoRepository.findById(webhookPagamentoResponse.getIdPedido());
        if(pedido.isPresent()){
            pedido.get().setId_status("4");
            pedidoRepository.save(pedido.get());
        }else{
            throw new RuntimeException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        return webhookPagamentoResponse;
    }
}
