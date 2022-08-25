package com.bootcamp.integrador.integradorback.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="nombre", length = 40, nullable = false)
    private String nombre;

    @Column (name="precio", length = 10, nullable = false)
    private int precio;

    @Column (name="cantidad", length = 10, nullable = false)
    private int cantidad;

    @Column (name="categoria", length = 40, nullable = false)
    private String categoria;


//    @OneToMany(
//            mappedBy = "producto",
//            fetch = FetchType.LAZY
//    )
//    private List <Venta> ventas;

}
