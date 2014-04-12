package com.ciandt.hackathon.entity;

import java.util.Collection;

import com.googlecode.objectify.annotation.Id;

public class User {

	@Id
	private Long id;
	private Table table;
	private Collection<Product> products;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	
}