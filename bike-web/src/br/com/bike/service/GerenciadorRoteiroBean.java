package br.com.bike.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.bike.modelo.Participante;
import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Roteiro;
import br.com.bike.modelo.Status;
import br.com.bike.modelo.TipoTrajeto;
import br.com.bike.modelo.Trajeto;
import br.com.bike.service.dao.PerfilDAO;
import br.com.bike.service.dao.RoteiroDAO;

@Stateless
public class GerenciadorRoteiroBean implements GerenciadorRoteiro {

	private static Map<Long, Roteiro> roteiros = new HashMap<Long, Roteiro>();

	@Inject
	private RoteiroDAO roteiroDAO;

	@Inject
	private PerfilDAO perfilDAO;

	public void criar() {
		System.out.println("Criando Roteiro");

		//o serviço de criação enviara o id do perfil
		Perfil perfil = perfilDAO.pesquisar(1L);

		Roteiro roteiro = new Roteiro();
		roteiro.setDescricao("Primeiro roteiro do Universo");
		roteiro.setDataCriacao(Calendar.getInstance());
		roteiro.setStatus(Status.ATIVO);
		roteiroDAO.salvar(roteiro);

		//cria o trajeto parametrizado.
		Trajeto trajeto = new Trajeto();
		trajeto.setDataInicioTrajeto(Calendar.getInstance());
		trajeto.setDataFimTrajeto(Calendar.getInstance());
		trajeto.setPerfil(perfil);
		trajeto.setTipoTrajeto(TipoTrajeto.MASTER);
		//falta informações do gps....
		roteiroDAO.salvar(trajeto);
		
		//INSERE OS TRAJETOS DENTRO DE ROTEIRO
		roteiro.setTrajetos(Arrays.asList(trajeto));

		//O roteiro não tera participante alem do criador....
		//Sera enviado uma lista de convites...
		//O participante inicial é sempre o criador do roteiro
		Participante participante = new Participante();
		participante.setDataInicioParticipacao(Calendar.getInstance());
		participante.getParticipanteId().setPerfil(perfil);
		participante.getParticipanteId().setRoteiro(roteiro);
		roteiroDAO.salvar(participante);


		System.out.println("Roteiro criado com sucesso");
	}

	public void pesquisar() {

	}

}
