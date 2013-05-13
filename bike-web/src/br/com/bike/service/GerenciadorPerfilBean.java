package br.com.bike.service;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Sexo;
import br.com.bike.modelo.Status;
import br.com.bike.modelo.TipoPerfil;
import br.com.bike.modelo.Usuario;
import br.com.bike.service.dao.PerfilDAO;


@Stateless
public class GerenciadorPerfilBean implements GerenciadorPerfil {

	@Inject
	private PerfilDAO perfilDAO;
	
	public Perfil login(Usuario usuario){
		return perfilDAO.login(usuario);
	}

	@Override
	public void criarPerfil() {
		Usuario usuarioDoPerfil = criarUsuario();
		Perfil perfil = new Perfil();
		perfil.setDataCriacao(Calendar.getInstance());
		perfil.setDataUltimoAcesso(Calendar.getInstance());
		perfil.setTipoPerfil(TipoPerfil.USER);
		perfil.setStatus(Status.ATIVO);
		perfil.setUsuario(usuarioDoPerfil);
		perfilDAO.salvar(perfil);
	}

	private Usuario criarUsuario() {
		Usuario u = new Usuario();
		u.setNome("Raffael");
		u.setApelido("Raffa");
		u.setEmail("raffa3lgu3d3s@gmail.com");
		u.setSenha("senha");
		u.setDataNascimento(Calendar.getInstance());
		u.setSexo(Sexo.MASCULINO);
		u.setStatus(Status.ATIVO);
		perfilDAO.salvar(u);
		return u;
	}
}
