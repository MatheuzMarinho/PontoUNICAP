package com.residencia.api.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Residente {
	
	@Id
	private String matricula;
	
	private String nome;

	public Residente() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
