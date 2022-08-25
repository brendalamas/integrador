package com.bootcamp.integrador.integradorback.servicio;

import com.bootcamp.integrador.integradorback.entidades.Venta;
import com.bootcamp.integrador.integradorback.exceptions.VentaNuloException;
import com.bootcamp.integrador.integradorback.exceptions.VentaYaExisteException;

import java.util.List;
import java.util.Optional;

public interface VentaService {

    List<Venta> listarVentas();
    Venta guardarVenta (Venta venta) throws VentaNuloException, VentaYaExisteException;
    Optional<Venta> buscarVentaPorID(Long id);

}
