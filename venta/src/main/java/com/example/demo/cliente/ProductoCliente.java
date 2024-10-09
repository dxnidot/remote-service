package com.example.demo.cliente;

import com.example.demo.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "producto", url = "http://localhost:8080")
public interface ProductoCliente {

    @GetMapping("/productos")
    List<Producto> getProductos();
}