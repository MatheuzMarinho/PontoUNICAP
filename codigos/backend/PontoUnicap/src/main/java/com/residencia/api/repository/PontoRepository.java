package com.residencia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.api.model.Ponto;
import com.residencia.api.model.PontoKey;

public interface PontoRepository extends JpaRepository<Ponto, PontoKey>{

}
