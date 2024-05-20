package com.fiap.checkout.infraestructure.api.persistence.repositories;

import com.fiap.checkout.infraestructure.persistence.entities.PagamentoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagamentoRepositoryTest {

    @Mock
    private JpaRepository<PagamentoEntity, String> pagamentoRepository;

    private PagamentoEntity pagamentoEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setId("1");
    }

    @Test
    void testFindById() {
        when(pagamentoRepository.findById("1")).thenReturn(Optional.of(pagamentoEntity));

        Optional<PagamentoEntity> result = pagamentoRepository.findById("1");

        assertTrue(result.isPresent());
        assertEquals(pagamentoEntity, result.get());
    }

    @Test
    void testFindById_NotFound() {
        when(pagamentoRepository.findById("2")).thenReturn(Optional.empty());

        Optional<PagamentoEntity> result = pagamentoRepository.findById("2");

        assertFalse(result.isPresent());
    }

    @Test
    void testSave() {
        when(pagamentoRepository.save(pagamentoEntity)).thenReturn(pagamentoEntity);

        PagamentoEntity result = pagamentoRepository.save(pagamentoEntity);

        assertEquals(pagamentoEntity, result);
    }

    @Test
    void testDelete() {
        pagamentoRepository.delete(pagamentoEntity);

        verify(pagamentoRepository, times(1)).delete(pagamentoEntity);
    }
}