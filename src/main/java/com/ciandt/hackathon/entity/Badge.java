package com.ciandt.hackathon.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Badge {

	private Long id;
	private String nome;
	private Long pontuacaoMinima;
	private List<Mesa> mesas;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPontuacaoMinima() {
		return pontuacaoMinima;
	}

	public void setPontuacaoMinima(Long pontuacaoMinima) {
		this.pontuacaoMinima = pontuacaoMinima;
	}

	@OneToMany(fetch = FetchType.LAZY)
	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

}
