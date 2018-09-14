package com.residencia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.api.model.Residente;

public interface ResidenteRepository  extends JpaRepository<Residente, String>{

}
