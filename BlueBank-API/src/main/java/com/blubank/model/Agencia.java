package com.blubank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private int id;

    @Column(name = "nome_agencia")
    private String nome_agencia;

    @OneToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "conta",
    //             joinColumns = @JoinColumn(name = "agencia_id_agencia"),
    //             inverseJoinColumns = @JoinColumn(name = "id_agencia")
    //             )
    @JoinColumn(name = "agencia_id_agencia")
    private List<Conta> conta;
}
