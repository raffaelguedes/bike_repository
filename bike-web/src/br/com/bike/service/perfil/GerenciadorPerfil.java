package br.com.bike.service.perfil;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * INTERFACE REST PARA SERVIÇOS DE PERFIL
 * @author Raffa
 *
 */
@Path("/gerenciadorPerfil")
@Produces("application/json")
@Local
public interface GerenciadorPerfil {
	
	@GET
	@Path("/login")
	String login();
}
