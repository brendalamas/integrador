package com.bootcamp.integrador.integradorback.controlador;

import com.bootcamp.integrador.integradorback.entidades.Vendedor;
import com.bootcamp.integrador.integradorback.servicio.VendedorService;
import com.bootcamp.integrador.integradorback.servicio.VendedorServiceImp;
import com.bootcamp.integrador.integradorback.servicio.VentaServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class VendedorController {

    private VendedorServiceImp vendedorServiceImp;

    public VendedorController(VendedorServiceImp vendedorServiceImp) {
        this.vendedorServiceImp = vendedorServiceImp;
    }

    //getAll de vendedores
    @GetMapping("/vendedores")
    public ResponseEntity<?> listarVendedores(){
        List<Vendedor> vendedores = this.vendedorServiceImp.listarVendedores();
        Map<String, Object> mensajeBody = new HashMap<>();
        if(vendedores.isEmpty()){
            mensajeBody.put("estado", Boolean.FALSE);
            mensajeBody.put("mensaje", "No hay datos de vendedores/empleados");
            return ResponseEntity
                    .badRequest()
                    .body(mensajeBody);
        }
        mensajeBody.put("estado", Boolean.TRUE);
        mensajeBody.put("datos", vendedores);
        return ResponseEntity.ok(mensajeBody);
    }

    // agregar vendedores - la entrada real es por aca
    @PostMapping("/vendedores")
    public Vendedor guardarVendedores(@RequestBody Vendedor vendedor){

        return this.vendedorServiceImp.guardarVendedor(vendedor);
    }
}
