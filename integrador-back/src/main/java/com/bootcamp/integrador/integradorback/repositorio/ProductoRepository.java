package com.bootcamp.integrador.integradorback.repositorio;

import com.bootcamp.integrador.integradorback.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(String categoria);
}
