package com.bootcamp.integrador.integradorback.controlador;

import com.bootcamp.integrador.integradorback.entidades.Producto;
import com.bootcamp.integrador.integradorback.servicio.ProductoService;
import com.bootcamp.integrador.integradorback.servicio.ProductoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductoController {

    private ProductoServiceImp productoServiceImp;

    public ProductoController(ProductoServiceImp productoServiceImp) {
        this.productoServiceImp = productoServiceImp;
    }

    @GetMapping("/productos")
    public ResponseEntity<?> listarProductos(){
        List<Producto> productos = this.productoServiceImp.listarProductos();
        Map<String, Object> mensajeBody = new HashMap<>();
        if(productos.isEmpty()){
            mensajeBody.put("estado", Boolean.FALSE);
            mensajeBody.put("mensaje", "No hay datos de productos");
            return ResponseEntity
                    .badRequest()
                    .body(mensajeBody);
        }
        mensajeBody.put("estado", Boolean.TRUE);
        mensajeBody.put("datos", productos);
        return ResponseEntity.ok(mensajeBody);
    }

    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto){
        return this.productoServiceImp.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> obtenerProductoPorID(@PathVariable Long id){
        Optional<Producto> producto = this.productoServiceImp.buscarPorID(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/productos/categoria/{categoria}")
    public ResponseEntity<?> obtenerProductoPorCategoria(@PathVariable String categoria){
        List<Producto> producto = this.productoServiceImp.getByCategoria(categoria);
        return ResponseEntity.ok(producto);
    }



    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        Map<String, Object> mensajeBody = new HashMap<>();
        Optional<Producto> productoBorrar = this.productoServiceImp.buscarPorID(id);

        if (!productoBorrar.isPresent()){
            mensajeBody.put("datos","El id no existe en la bd");
            return ResponseEntity.badRequest().body(mensajeBody);
        }else{
            this.productoServiceImp.eliminarProducto(productoBorrar.get());
            mensajeBody.put("datos","Se ha borrado el usuario correctamente");
            return ResponseEntity.ok(mensajeBody);
        }    }
}
