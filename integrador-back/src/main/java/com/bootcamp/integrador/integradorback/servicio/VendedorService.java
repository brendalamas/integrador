package com.bootcamp.integrador.integradorback.servicio;

import com.bootcamp.integrador.integradorback.entidades.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {

    List<Vendedor> listarVendedores();
    Vendedor guardarVendedor (Vendedor vendedor);
    Optional<Vendedor> buscarPorID (Long id);
}
