package com.fiap.checkout.infraestructure.adapters.pagamento;

import com.fiap.checkout.infraestructure.api.responses.EfetuarPagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.checkout.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.checkout.core.ports.out.pagamento.EfetuarPagamentoOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EfetuarPagamentoAdapter implements EfetuarPagamentoOutputPort {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public EfetuarPagamentoAdapter(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse) {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("3"); //Tipo pagto - Mercado pago
        Optional<PedidoEntity> pedido = pedidoRepository.findById(efetuarPagamentoResponse.getIdPedido());

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(efetuarPagamentoResponse.getIdPedido());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setId_status("3");
            pedidoEntity.get().setId_pagamento("3");
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new RuntimeException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        efetuarPagamentoResponse.setTipoPagamento(pagamento.get().getNome());
        efetuarPagamentoResponse.setValor(pedido.get().getValor_total());

        return efetuarPagamentoResponse;
    }
}
