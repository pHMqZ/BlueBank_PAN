package com.bluebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bluebank.model.Conta;
import com.bluebank.model.Movimento;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	@Query(value = "SELECT movimento FROM Movimento movimento WHERE movimento.conta.id = :contaId")
	public List<Movimento> findByContaId(@Param("contaId") int contaId);
}
