package com.example.demo.cliente;

import com.example.demo.model.Categoria;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "categoria", url = "http://localhost:8080")
public interface CategoriaCliente {
    @GetMapping("/categorias")
    List<Categoria> getCategorias();
}


