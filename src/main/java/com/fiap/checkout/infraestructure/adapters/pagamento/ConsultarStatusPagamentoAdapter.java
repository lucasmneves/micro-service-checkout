package com.fiap.checkout.infraestructure.adapters.pagamento;

import com.fiap.checkout.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import com.fiap.checkout.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.checkout.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.checkout.core.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ConsultarStatusPagamentoAdapter implements ConsultarStatusPagamentoOutputPort {
    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;
    @Autowired
    public ConsultarStatusPagamentoAdapter(
            PagamentoRepository pagamentoRepository,
            PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse) {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("3"); //Tipo pagto - Mercado pago

        Optional<PedidoEntity> pedido = pedidoRepository.findById(consultarStatusPagamentoResponse.getIdPedido());
        if(pedido.isPresent()){
            consultarStatusPagamentoResponse.setTipoPagamento(pagamento.get().getNome());
            consultarStatusPagamentoResponse.setValor(pedido.get().getValor_total());
            consultarStatusPagamentoResponse.setSenha(pedido.get().getSenha());
            if(pedido.get().getId_status().equals("4")){
                consultarStatusPagamentoResponse.setStatus("Confirmado");
                consultarStatusPagamentoResponse.setMensagem("Pagamento confirmado!");
            }else{
                consultarStatusPagamentoResponse.setStatus("Pendente");
                consultarStatusPagamentoResponse.setMensagem("Aguardando pagamento");
            }
        }else{
            throw new RuntimeException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        return consultarStatusPagamentoResponse;
    }
}
