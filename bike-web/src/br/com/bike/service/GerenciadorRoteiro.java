package br.com.bike.service;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * INTERFACE DE SERVIÇOS REST PARA A SESSÃO (PEDALADA)
 * @author Raffa
 *
 */
@Path("/gerenciadorRoteiro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Local
public interface GerenciadorRoteiro {
	
	@GET
	@Path("/criarRoteiro")
	void criar();
	
	@GET
	@Path("/pesquisar")
	void pesquisar();
}
