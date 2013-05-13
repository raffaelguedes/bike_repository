package br.com.bike.service;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Usuario;

/**
 * INTERFACE REST PARA SERVIÇOS DE PERFIL
 * @author Raffa
 *
 */
@Path("/gerenciadorPerfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Local
public interface GerenciadorPerfil {
	
	@POST
	@Path("/login")
	Perfil login(Usuario usuario);
	
	@GET
	@Path("/criarPerfil")
	void criarPerfil();
}
