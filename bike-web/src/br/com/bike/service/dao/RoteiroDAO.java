package br.com.bike.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.bike.modelo.GoogleMap;
import br.com.bike.modelo.Participante;
import br.com.bike.modelo.Roteiro;
import br.com.bike.modelo.TipoParticipacao;
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
	
	public List<Roteiro> carregarRoteiros(Long perfilId){
		String jpql = "select r from Roteiro r " +
				"join r.trajetos t " +
				"join t.googleMap g " +
				"join g.wayPoints w " +
				"join r.participantes p " +
				"where p.participanteId.perfil.id = :perfilId and p.tipoParticipacao = :tipoParticipacao";
		TypedQuery<Roteiro> query = manager.createQuery(jpql, Roteiro.class);
		query.setParameter("perfilId", perfilId);
		query.setParameter("tipoParticipacao", TipoParticipacao.CRIADOR);
		
		return query.getResultList();
	}

	public void salvar(Trajeto trajeto) {
		manager.persist(trajeto);
	}

	public void salvar(Participante participante) {
		manager.persist(participante);
	}
	
	public void salvar(GoogleMap googleMap){
		manager.persist(googleMap);
	}
}
