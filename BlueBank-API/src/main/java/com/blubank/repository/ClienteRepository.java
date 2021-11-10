package com.blubank.repository;

import com.blubank.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
