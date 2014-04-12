package com.ciandt.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compra {
	private Long id;
	private Pessoa pessoa;
	private Item item;
	private Long numeroPontos;
	private Boolean aprovada;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getNumeroPontos() {
		return numeroPontos;
	}

	public void setNumeroPontos(Long numeroPontos) {
		this.numeroPontos = numeroPontos;
	}

	public Boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(Boolean aprovada) {
		this.aprovada = aprovada;
	}

}
