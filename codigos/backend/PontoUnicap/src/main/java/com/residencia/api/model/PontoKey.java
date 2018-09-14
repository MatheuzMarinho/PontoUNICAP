package com.residencia.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PontoKey  implements Serializable{
	 
	private LocalDate data;
	 
	 @ManyToOne
	 @JoinColumn(name="residente_matricula")
	 private Residente residente;
	 
	 public PontoKey() {
		 
	 }

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}
	 
	 
}

