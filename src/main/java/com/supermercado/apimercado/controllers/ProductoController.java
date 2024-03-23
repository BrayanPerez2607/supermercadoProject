package com.supermercado.apimercado.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermercado.apimercado.model.Producto;

@RestController
@RequestMapping("/api/supermercado")
public class ProductoController {
    
    private List<Producto> productos;

    public ProductoController(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Producto[] productoArrays = objectMapper.readValue(new ClassPathResource("products.json").getFile(), Producto[].class);
            productos = new ArrayList<>(Arrays.asList(productoArrays));
        } catch (IOException e) {
            e.printStackTrace();
            productos = new ArrayList<>();
        }
    }

    @GetMapping
    public  List<Producto> getAllProductos() {
        return productos;
    }

    @GetMapping("/{codigo}")
    public Producto getProductoByCodigo(@PathVariable Integer codigo){
        return productos.stream().filter(producto -> producto.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        productos.add(producto);
        return producto;
    }

    @PutMapping("/{codigo}")
    public Producto updateProducto(@PathVariable Integer codigo, @RequestBody Producto updateProducto){
        Producto producto = getProductoByCodigo(codigo);
        if (producto != null) {
            producto.setNombre(updateProducto.getNombre());
            producto.setPrecio(updateProducto.getPrecio());
            producto.setCategoria(updateProducto.getCategoria());
            producto.setPeso(updateProducto.getPeso());
        }
        return null;
    }

    @DeleteMapping("/{codigo}")
    public void deleteUser(@PathVariable Integer codigo){
        productos.removeIf(producto -> producto.getCodigo().equals(codigo));
    }    

}
