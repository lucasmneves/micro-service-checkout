package com.fiap.checkout.core.domain.entities;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatusDTOTest {

    @Test
    public void testGetId() {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId("123");
        assertEquals("123", statusDTO.getId());
    }

    @Test
    public void testSetId() {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId("123");
        assertEquals("123", statusDTO.getId());
    }

    @Test
    public void testGetDescricao() {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setDescricao("Test Description");
        assertEquals("Test Description", statusDTO.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setDescricao("Test Description");
        assertEquals("Test Description", statusDTO.getDescricao());
    }

    @Test
    public void testGetSerialVersionUID() {
        assertEquals(1L, StatusDTO.getSerialVersionUID());
    }
}