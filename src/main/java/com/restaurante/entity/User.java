package com.restaurante.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="token")
    private String token;

    @Column(name="date_create")
    @CreationTimestamp
    private Date dateCreate;

    @Column(name="update_create")
    @UpdateTimestamp
    private Date dateUpdate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Cliente cliente;
}
