//package com.example.demo.service;
//
//import com.example.demo.model.Producto;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ProductoService {
//
//    private List<Producto> productos = new ArrayList<>();
//
//    public List<Producto> findAll() {
//        return productos;
//    }
//
//    public Producto save(Producto producto) {
//        productos.add(producto);
//        return producto;
//    }
//
//    public Producto findById(Long id) {
//        return productos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public Producto update(Long id, Producto producto) {
//        for (int i = 0; i < productos.size(); i++) {
//            if (productos.get(i).getId().equals(id)) {
//                productos.set(i, producto);
//                return producto;
//            }
//        }
//        return null;
//    }
//
//    public void delete(Long id) {
//        productos.removeIf(p -> p.getId().equals(id));
//    }
//}
//
//
