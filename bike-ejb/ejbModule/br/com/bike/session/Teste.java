package br.com.bike.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Teste {

	@PersistenceContext
	EntityManager em;
}
