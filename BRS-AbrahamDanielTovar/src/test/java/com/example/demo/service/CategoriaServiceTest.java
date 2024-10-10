package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    void testGetAllCategorias() {
        List<Categoria> categorias = Arrays.asList(new Categoria(1L, "Electrónica"), new Categoria(2L, "Hogar"));
        when(categoriaRepository.findAll()).thenReturn(categorias);

        List<Categoria> result = categoriaService.getAllCategorias();

        assertEquals(2, result.size());
    }

    @Test
    void testCreateCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Ropa");

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria result = categoriaService.createCategoria(categoria);

        assertEquals("Ropa", result.getNombre());
    }

    @Test
    void testUpdateCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Muebles");

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria result = categoriaService.updateCategoria(1L, categoria);

        assertEquals("Muebles", result.getNombre());
    }

    @Test
    void testDeleteCategoria() {
        Long categoriaId = 1L;
        doNothing().when(categoriaRepository).deleteById(categoriaId);

        assertDoesNotThrow(() -> categoriaService.deleteCategoria(categoriaId));
        verify(categoriaRepository, times(1)).deleteById(categoriaId);
    }
}



