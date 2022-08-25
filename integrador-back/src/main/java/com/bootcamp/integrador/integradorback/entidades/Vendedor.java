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
@Table(name="vendedores")
public class Vendedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="nombre", length = 40, nullable = false)
    private String nombre;

    @Column (name="apellido", length = 40, nullable = false)
    private String apellido;

    @Column (name="sueldo", length = 10, nullable = false)
    private int sueldo;

//    @OneToMany(
//            mappedBy = "vendedor",
//            fetch = FetchType.LAZY
//    )
//    private List <Venta> ventas;


}
