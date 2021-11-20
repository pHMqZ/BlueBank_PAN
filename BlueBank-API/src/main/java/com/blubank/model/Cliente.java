package com.blubank.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id; //conta bancaria;
	
	@Column(name ="nome_cliente")
	@NotEmpty(message ="O nome deve ser preenchido")
	private String nome;
	
	@Column(name ="data_inicio")
	private Date data_ini;

	@Column(name ="data_fim")
	private Date data_fim;

    @OneToOne(cascade=CascadeType.ALL)
    private DadoCliente dadoCliente;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_ini() {
        return this.data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Date getData_fim() {
        return this.data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }


	//@OneToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name = "fk_dado",nullable=false)
	//private DadoCliente dado_cliente;

	

	
}