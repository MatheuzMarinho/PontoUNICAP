package com.residencia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.api.model.Residente;
import com.residencia.api.repository.ResidenteRepository;

@CrossOrigin
@RestController
@RequestMapping("/residente")
public class ResidenteController {
	
	@Autowired
	private ResidenteRepository rr;
	
	 @GetMapping("/residentes")
	 public ResponseEntity<List<Residente>>listar(){
	        List<Residente> residentes = rr.findAll();
	        return new ResponseEntity<>(residentes, HttpStatus.OK);
	    }
	 
	 @PostMapping
	 public ResponseEntity<Void> inserir(@RequestBody Residente residente) {

	        rr.save(residente);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }

}
