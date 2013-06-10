package br.com.bike.service;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bike.modelo.GoogleMap;
import br.com.bike.response.RoteiroResponse;

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
	
	@POST
	@Path("/criarRoteiro")
	void criar(GoogleMap googleMap);
	
	@GET
	@Path("/carregarRoteiros/{perfilId}")
	List<RoteiroResponse> carregarRoteiros(@PathParam("perfilId") Long perfilId);
}
