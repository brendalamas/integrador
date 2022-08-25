package com.bootcamp.integrador.integradorback.servicio;

import com.bootcamp.integrador.integradorback.entidades.Venta;
import com.bootcamp.integrador.integradorback.exceptions.VentaNuloException;
import com.bootcamp.integrador.integradorback.exceptions.VentaYaExisteException;
import com.bootcamp.integrador.integradorback.repositorio.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImp implements VentaService {
    private final VentaRepository ventaRepository;

    public VentaServiceImp(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> listarVentas() {

        return this.ventaRepository.findAll();
    }

    @Override
    public Venta guardarVenta(Venta venta) throws VentaNuloException, VentaYaExisteException {
        if (venta != null ) {
            if (ventaRepository.findById(venta.getId()).isPresent()) {
                throw new VentaYaExisteException("Ya hay registrado una venta identica");
            }
            return ventaRepository.save(venta);
        } else {
            throw new VentaNuloException();
        }
    }

    @Override
    public Optional<Venta> buscarVentaPorID(Long id) {
        return this.ventaRepository.findById(id);
    }


}
