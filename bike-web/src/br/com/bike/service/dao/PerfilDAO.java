package br.com.bike.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Usuario;


public class PerfilDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public Perfil login(Usuario usuario){
		//createcreteria;;;;
		return new Perfil();
	}
	
	public void salvar(Usuario usuario){
		manager.persist(usuario);
	}
	
	public void salvar(Perfil perfil){
		manager.persist(perfil);
	}

	public Perfil pesquisar(Long id) {
		return manager.find(Perfil.class, id);
	}
}
