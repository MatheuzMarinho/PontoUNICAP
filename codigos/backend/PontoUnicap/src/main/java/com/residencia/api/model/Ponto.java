package com.residencia.api.model;



import java.time.LocalTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Ponto{
	
	@EmbeddedId
    private PontoKey id;
	
	private LocalTime entrada;
	private LocalTime saida;
	
	
	
	public Ponto() {}



	public PontoKey getId() {
		return id;
	}



	public void setId(PontoKey id) {
		this.id = id;
	}



	public LocalTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalTime entrada) {
		this.entrada = entrada;
	}

	public LocalTime getSaida() {
		return saida;
	}

	public void setSaida(LocalTime saida) {
		this.saida = saida;
	}

}


