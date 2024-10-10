package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
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
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void testGetAllProductos() {
        List<Producto> productos = Arrays.asList(new Producto(1L, "Laptop", 1000, 1L), new Producto(2L, "Mouse", 25, 1L));
        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> result = productoService.getAllProductos();

        assertEquals(2, result.size());
    }

    @Test
    void testCreateProducto() {
        Producto producto = new Producto();
        producto.setNombre("Teclado");
        producto.setPrecio(45.0);
        producto.setCategoriaId(1L);

        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto result = productoService.createProducto(producto);

        assertEquals("Teclado", result.getNombre());
    }

    @Test
    void testUpdateProducto() {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Monitor");
        producto.setPrecio(200.0);
        producto.setCategoriaId(2L);

        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto result = productoService.updateProducto(1L, producto);

        assertEquals("Monitor", result.getNombre());
    }

    @Test
    void testDeleteProducto() {
        Long productoId = 1L;
        doNothing().when(productoRepository).deleteById(productoId);

        assertDoesNotThrow(() -> productoService.deleteProducto(productoId));
        verify(productoRepository, times(1)).deleteById(productoId);
    }
}
