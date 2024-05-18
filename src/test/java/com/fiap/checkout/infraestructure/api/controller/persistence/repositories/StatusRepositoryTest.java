package com.fiap.checkout.infraestructure.api.controller.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.StatusEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
public class StatusRepositoryTest {

    @MockBean
    private JpaRepository<StatusEntity, String> statusRepository;

    @Test
    public void testFindById() {
        String id = "1";
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setId(id);
        Mockito.when(statusRepository.findById(id)).thenReturn(Optional.of(statusEntity));

        Optional<StatusEntity> result = statusRepository.findById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @Test
    public void testFindById_NotFound() {
        String id = "1";
        Mockito.when(statusRepository.findById(id)).thenReturn(Optional.empty());

        Optional<StatusEntity> result = statusRepository.findById(id);

        assertFalse(result.isPresent());
    }

    @Test
    public void testSave() {
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setId("1");
        Mockito.when(statusRepository.save(statusEntity)).thenReturn(statusEntity);

        StatusEntity result = statusRepository.save(statusEntity);

        assertNotNull(result);
        assertEquals(statusEntity.getId(), result.getId());
    }

    @Test
    public void testDelete() {
        String id = "1";

        statusRepository.deleteById(id);

        Mockito.verify(statusRepository, Mockito.times(1)).deleteById(id);
    }
}