package com.fiap.checkout.infraestructure.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, String>{
}
