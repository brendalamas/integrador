package com.bootcamp.integrador.integradorback.servicio;

import com.bootcamp.integrador.integradorback.entidades.Vendedor;
import com.bootcamp.integrador.integradorback.repositorio.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImp implements VendedorService{

    private VendedorRepository vendedorRepository;

    public VendedorServiceImp(VendedorRepository vendedorRepository) {

        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public List<Vendedor> listarVendedores() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor guardarVendedor(Vendedor vendedor) {

        return vendedorRepository.save(vendedor);
    }

    @Override
    public Optional<Vendedor> buscarPorID(Long id) {

        return vendedorRepository.findById(id);
    }
}
