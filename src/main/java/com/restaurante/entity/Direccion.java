package com.restaurante.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "direccion")
@Getter
@Setter
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="tipo_via")
    private String tipoVia;

    @Column(name="calle")
    private String calle;

    @Column(name="numero")
    private String numero;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="provincia")
    private String provincia;

    @Column(name="pais")
    private String pais;

    @Column(name="cp")
    private String cp;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "direccion")
    @JsonManagedReference
    private Set<Pedido> pedido;
}
