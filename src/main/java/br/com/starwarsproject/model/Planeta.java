package br.com.starwarsproject.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {
	
	@Id
	private String id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	@NotEmpty(message = "Clima não pode ser vazio")
	private String clima;
	
	@NotEmpty(message = "Terreno não pode ser vazio")
	private String terreno;
	
	@Transient
	private int numeroApraricoes;

	public Planeta() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}
	
	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	public int getNumeroApraricoes() {
		return numeroApraricoes;
	}

	public void setNumeroApraricoes(int numeroApraricoes) {
		this.numeroApraricoes = numeroApraricoes;
	}
}
