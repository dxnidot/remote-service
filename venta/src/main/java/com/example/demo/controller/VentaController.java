package com.example.demo.controller;

import com.example.demo.cliente.ProductoCliente;
import com.example.demo.cliente.CategoriaCliente;
import com.example.demo.model.Producto;
import com.example.demo.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private ProductoCliente productoCliente;

    @Autowired
    private CategoriaCliente categoriaCliente;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoCliente.getProductos();
    }

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
        return categoriaCliente.getCategorias();
    }
}


