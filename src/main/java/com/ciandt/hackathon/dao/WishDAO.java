package com.ciandt.hackathon.dao;

import java.util.List;

import com.ciandt.hackathon.entity.Wish;

public interface WishDAO {
	
	public List<Wish>findWishes(); 
	public Long insert( Wish wish );
	public void delete(Wish wish); 
	public void update(Wish wish);
	
//	public void markAsIntended( Wish wish); 
//	public void realize(Wish wish);
//	public void dontRealize(Wish wish); 

}