package com.fiap.checkout.infraestructure.persistence.mapper;

import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.checkout.core.domain.entities.PedidoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {
    PedidoEntity toPedidoEntity(PedidoDTO pedido);
}
