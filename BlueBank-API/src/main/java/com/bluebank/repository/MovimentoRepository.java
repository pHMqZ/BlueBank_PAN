package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.Movimento;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {
}
