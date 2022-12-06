package com.restaurante.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "plato_restaurante")
@Getter
@Setter
public class PlatoRestaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio_base")
    private BigDecimal precioBase;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurante restaurante;

    //OneToOne, hay que poner la columna que relaciona
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PlatoPedido platoPedido;

}
