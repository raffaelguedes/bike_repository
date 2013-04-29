package br.com.bike.session;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.bike.modelo.Usuario;


@Stateless
@Path("loginService")
public class LoginResource {
	
	@GET
	@Path("/login")
	@Produces("application/json")
	public void login(Usuario usuario){
		
	}
}
