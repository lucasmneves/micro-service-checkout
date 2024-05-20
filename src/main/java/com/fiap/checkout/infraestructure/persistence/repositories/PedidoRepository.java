package com.fiap.checkout.infraestructure.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, String>{
}
