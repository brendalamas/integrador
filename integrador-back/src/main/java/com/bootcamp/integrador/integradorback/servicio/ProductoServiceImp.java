package com.bootcamp.integrador.integradorback.servicio;

import com.bootcamp.integrador.integradorback.entidades.Producto;
import com.bootcamp.integrador.integradorback.repositorio.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService {

    private ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarProductos() {

        return productoRepository.findAll();
    }
    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    @Override
    public Optional<Producto> buscarPorID(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> getByCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public void eliminarProducto (Producto producto) {
        productoRepository.delete(producto);
    }

}
