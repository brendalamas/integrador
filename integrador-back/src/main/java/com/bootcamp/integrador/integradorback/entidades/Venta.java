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
@Table(name = "ventas")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            optional = true
    )
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            optional = true
    )
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

}
