package com.bootcamp.integrador.integradorback.repositorio;

import com.bootcamp.integrador.integradorback.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
