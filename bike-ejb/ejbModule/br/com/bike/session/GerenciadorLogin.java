package br.com.bike.session;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Usuario;

public interface GerenciadorLogin {
	public Perfil login(Usuario usuario);
}
