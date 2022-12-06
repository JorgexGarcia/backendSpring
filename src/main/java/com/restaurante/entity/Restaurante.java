package com.restaurante.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

/**
 * Entity porque es entidad
 * Tabla, nombre de la tabla
 * Getter, para que cree los getters
 */
@Entity
@Table(name="restaurante")
@Getter
@Setter
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="img_logo")
    private String imgLogo;

    @Column(name="localizacion")
    private String localizacion;

    @Column(name="destacado")
    private boolean destacado;

    //Crea automaticamente la fecha de creacion
    @Column(name="data_created")
    @CreationTimestamp
    private Date dataCreated;

    //Crea automaticamente la fecha de actualizacion
    @Column(name="data_update")
    @UpdateTimestamp
    private String dataUpdate;

    @Column(name = "img_restaurante")
    private String imgRestaurante;

    //JsonBackRefence para hacer la relacion inversa, siempre en las ManyToOne
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    //JsonManagedReference para hacer la relacion inversa, siempre en las OneToMany
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<Horario> horarios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<Comentario> comentarios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<Pedido> pedidos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<PlatoRestaurante> platosRestaurante;
}
