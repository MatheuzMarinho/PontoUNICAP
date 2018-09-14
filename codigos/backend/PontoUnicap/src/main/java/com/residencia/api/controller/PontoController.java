package com.residencia.api.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.api.model.Ponto;
import com.residencia.api.repository.PontoRepository;

@CrossOrigin
@RestController
@RequestMapping("/ponto")
public class PontoController {

	@Autowired
	private PontoRepository pr;
	
	 @GetMapping("/pontos")
	 public ResponseEntity<List<Ponto>>listar(){
	        List<Ponto> pontos = pr.findAll();
	        return new ResponseEntity<>(pontos, HttpStatus.OK);
	    }
	 
	 @PostMapping
	 public ResponseEntity<?> entradaPonto(@RequestBody Ponto ponto) {
		 	ponto.getId().setData(LocalDate.now());
		 	ponto.setEntrada(LocalTime.now());
	        if(! pr.existsById(ponto.getId())) {
		        pr.save(ponto);
		        return new ResponseEntity<>(ponto,HttpStatus.CREATED);
	        }
	        
	        return new ResponseEntity<>("Residente possui ponto cadastrado para o dia atual.",HttpStatus.NOT_ACCEPTABLE);
	    }
	 
	 @PutMapping
	 public ResponseEntity<?> saidaPonto(@RequestBody Ponto ponto) {
		 	ponto.getId().setData(LocalDate.now());
		 	
		    if(pr.existsById(ponto.getId())) {
		    	ponto = pr.getOne(ponto.getId());
		    	if(ponto.getSaida() != null) {
		    		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Residente já bateu o ponto de saida!");
		    	}
			 	ponto.setSaida(LocalTime.now());
			 	ponto =  pr.save(ponto);
		        return new ResponseEntity<>(ponto, HttpStatus.CREATED);
	        }
	     
	        
	        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Residente não bateu o ponto de entrada!");
	    }
	
}
