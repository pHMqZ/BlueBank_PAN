package com.blubank.repository;

import com.blubank.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
																   //Alteração para Long porque não estava puxando os dados como Integer.
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
