package br.com.bike.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PerfilDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public String login(){
		return "Login valido, pode avançar....";
	}

}
