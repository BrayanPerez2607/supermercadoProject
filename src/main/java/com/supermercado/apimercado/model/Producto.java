package com.supermercado.apimercado.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    
    private Integer codigo;
    private String precio;
    private String nombre;
    private String categoria;
    private String peso;
    
}
