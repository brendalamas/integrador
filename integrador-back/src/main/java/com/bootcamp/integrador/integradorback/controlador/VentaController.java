package com.bootcamp.integrador.integradorback.controlador;

import com.bootcamp.integrador.integradorback.entidades.Venta;
import com.bootcamp.integrador.integradorback.exceptions.VentaNuloException;
import com.bootcamp.integrador.integradorback.exceptions.VentaYaExisteException;
import com.bootcamp.integrador.integradorback.servicio.VentaServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class VentaController {

    private VentaServiceImp ventaServiceImp;

    public VentaController(VentaServiceImp ventaServiceImp) {
        this.ventaServiceImp = ventaServiceImp;
    }

    @GetMapping("/ventas")
    public ResponseEntity<?> listarVentas(){
        List<Venta> ventas = this.ventaServiceImp.listarVentas();
        Map<String, Object> mensajeBody = new HashMap<>();
        if(ventas.isEmpty()){
            mensajeBody.put("estado", Boolean.FALSE);
            mensajeBody.put("mensaje", "No hay datos de ventas");
            return ResponseEntity
                    .badRequest()
                    .body(mensajeBody);
        }
        mensajeBody.put("estado", Boolean.TRUE);
        mensajeBody.put("datos", ventas);
        return ResponseEntity.ok(mensajeBody);
    }


    @GetMapping("/ventas/{id}")
    public ResponseEntity<?> ventaPorID(@PathVariable Long id) throws VentaNuloException {
        Optional<Venta> venta = this.ventaServiceImp.buscarVentaPorID(id);
        if (!venta.isPresent()){
            throw new VentaNuloException("la venta que desea buscar no existe");
        }
        return ResponseEntity.ok(venta);
    }

    @PostMapping("/ventas")
    public ResponseEntity<?> altaVenta (@RequestBody Venta venta) {
        try{
            Venta addventa = this.ventaServiceImp.guardarVenta(venta);
            return ResponseEntity.ok(addventa);
        }catch (VentaYaExisteException e){
            return ResponseEntity.badRequest().body("ya existe la venta. detalle: " + e.getMessage());
        }catch (VentaNuloException e){
            return ResponseEntity.badRequest().body("la venta no puede ser nuela");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("error interno desconocido");
        }
    }


}
