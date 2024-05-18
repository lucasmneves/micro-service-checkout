package com.fiap.checkout.infraestructure.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, String>{
}
