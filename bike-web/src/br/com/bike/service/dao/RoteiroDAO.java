package br.com.bike.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.bike.modelo.Participante;
import br.com.bike.modelo.Roteiro;
import br.com.bike.modelo.Trajeto;

public class RoteiroDAO {

	@PersistenceContext
	EntityManager manager;
	
	public void salvar(Roteiro roteiro){
		manager.persist(roteiro);
	}
	
	public Roteiro pesquisar(Long id){
		return manager.getReference(Roteiro.class, id);
	}

	public void salvar(Trajeto trajeto) {
		manager.persist(trajeto);
	}

	public void salvar(Participante participante) {
		manager.persist(participante);
	}
}
