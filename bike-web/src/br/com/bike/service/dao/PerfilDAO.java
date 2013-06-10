package br.com.bike.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Usuario;


public class PerfilDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public Perfil login(Usuario usuario){
		String jpql = "select p from Perfil p " +
				"join p.usuario u " +
				"left join p.enderecos e " +
				"left join p.telefones t " +
				"left join p.bikes b " +
				"where u.email = :email and u.senha = :senha";
		TypedQuery<Perfil> query = manager.createQuery(jpql, Perfil.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		
		Perfil perfil = query.getSingleResult();
		
		return perfil;
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
