package com.bootcamp.integrador.integradorback.repositorio;

import com.bootcamp.integrador.integradorback.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
