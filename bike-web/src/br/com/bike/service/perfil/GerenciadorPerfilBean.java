package br.com.bike.service.perfil;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.bike.dao.PerfilDAO;


@Stateless
public class GerenciadorPerfilBean implements GerenciadorPerfil {

	@Inject
	private PerfilDAO perfilDAO;
	
	public String login(){
		return perfilDAO.login();
	}
}
