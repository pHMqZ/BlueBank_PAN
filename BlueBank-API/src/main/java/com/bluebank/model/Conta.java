package com.bluebank.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;
    
    @Column(name = "saldo")
    private double saldo;
    
    @Column(name = "nome_conta")
    private String nome;

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_abertura = new java.sql.Date(System.currentTimeMillis());
    
 


    @Column(name = "data_fechamento")
    private Date data_fechamento;

    @Column(name = "debito_bloqueado")
    private boolean debito;

    @ManyToOne
    private Agencia age;

    @Column(name = "lista_movimento")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id_conta")
    private List<Movimento> movimento;
 

    

    
    
    public Conta() {
    
    }
    
    
    public Conta(String nome, Double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}

	public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_abertura() {
        return this.data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_fechamento() {
        return this.data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public boolean isDebito() {
        return this.debito;
    }

    public boolean getDebito() {
        return this.debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Agencia getAge() {
		return age;
	}

	public void setAge(Agencia age) {
		this.age = age;
	}

	public List<Movimento> getMovimento() {
		return movimento;
	}

	public void setMovimento(List<Movimento> movimento) {
		this.movimento = movimento;
	}

	
    
    

    // public Cliente getCliente() {
    //     return this.cliente;
    // }

    // public void setCliente(Cliente cliente) {
    //     this.cliente = cliente;
    // }
    

}
