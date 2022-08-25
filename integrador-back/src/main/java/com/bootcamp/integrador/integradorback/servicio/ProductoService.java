package com.bootcamp.integrador.integradorback.servicio;

import com.bootcamp.integrador.integradorback.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listarProductos();
    Producto guardarProducto (Producto producto);
    Optional<Producto> buscarPorID (Long id);

    List<Producto> getByCategoria(String categoria);

}
