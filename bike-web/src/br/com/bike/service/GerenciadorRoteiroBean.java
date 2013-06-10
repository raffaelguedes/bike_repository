package br.com.bike.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.bike.modelo.GoogleMap;
import br.com.bike.modelo.Participante;
import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Roteiro;
import br.com.bike.modelo.Status;
import br.com.bike.modelo.TipoParticipacao;
import br.com.bike.modelo.TipoTrajeto;
import br.com.bike.modelo.Trajeto;
import br.com.bike.modelo.WayPoint;
import br.com.bike.response.GoogleMapResponse;
import br.com.bike.response.ParticipanteResponse;
import br.com.bike.response.RoteiroResponse;
import br.com.bike.response.TrajetoResponse;
import br.com.bike.response.WayPointResponse;
import br.com.bike.service.dao.PerfilDAO;
import br.com.bike.service.dao.RoteiroDAO;

@Stateless
public class GerenciadorRoteiroBean implements GerenciadorRoteiro {

	@Inject
	private RoteiroDAO roteiroDAO;

	@Inject
	private PerfilDAO perfilDAO;

	public void criar(GoogleMap googleMap) {
		
		//TODO Foi a primeira forma de passar o id do perfil - melhorar
		Perfil perfil = perfilDAO.pesquisar(googleMap.getId());
		
		Roteiro roteiro = new Roteiro();
		roteiro.setDescricao("Primeiro roteiro do Universo");
		roteiro.setDataCriacao(Calendar.getInstance());
		roteiro.setStatus(Status.ATIVO);
		roteiroDAO.salvar(roteiro);
		
		//TODO SHIT...MELHORAR
		googleMap.setId(null);
		roteiroDAO.salvar(googleMap);
		
		//cria o trajeto parametrizado.
		Trajeto trajeto = new Trajeto();
		trajeto.setRoteiro(roteiro);
		trajeto.setDataInicioTrajeto(Calendar.getInstance());
		trajeto.setDataFimTrajeto(Calendar.getInstance());
		trajeto.setPerfil(perfil);
		trajeto.setTipoTrajeto(TipoTrajeto.MASTER);
		trajeto.setGoogleMap(googleMap);
		roteiroDAO.salvar(trajeto);
		
		//INSERE OS TRAJETOS DENTRO DE ROTEIRO
		roteiro.getTrajetos().add(trajeto);

		//Sera enviado uma lista de convites...
		//O participante inicial é sempre o criador do roteiro
		Participante participante = new Participante();
		participante.setStatus(Status.ATIVO);
		participante.setTipoParticipacao(TipoParticipacao.CRIADOR);
		participante.setDataInicioParticipacao(Calendar.getInstance());
		participante.getParticipanteId().setPerfil(perfil);
		participante.getParticipanteId().setRoteiro(roteiro);
		roteiroDAO.salvar(participante);
	}

	@Override
	public List<RoteiroResponse> carregarRoteiros(Long idPerfil) {
		List<Roteiro> roteiros = roteiroDAO.carregarRoteiros(idPerfil);
		List<RoteiroResponse> roteirosResponse = new ArrayList<RoteiroResponse>();
		for(Roteiro r : roteiros){
			RoteiroResponse rr = new RoteiroResponse();
			rr.setDataCriacao(r.getDataCriacao());
			rr.setDescricao(r.getDescricao());
			rr.setId(r.getId());
			for(Participante p : r.getParticipantes()){
				ParticipanteResponse pr = new ParticipanteResponse();
				pr.setDataInicioParticipacao(p.getDataInicioParticipacao());
				pr.setPerfil(p.getParticipanteId().getPerfil());
				pr.setStatus(p.getStatus());
				pr.setTipoParticipacao(p.getTipoParticipacao());
				rr.getParticipantes().add(pr);
			}
			for(Trajeto t : r.getTrajetos()){
				TrajetoResponse tr = new TrajetoResponse();
				tr.setDataFimTrajeto(t.getDataFimTrajeto());
				tr.setDataInicioTrajeto(t.getDataInicioTrajeto());
				//tr.setGoogleMap(t.getGoogleMap());
				tr.setId(t.getId());
				tr.setPerfil(t.getPerfil());
				tr.setTipoTrajeto(t.getTipoTrajeto());
				tr.setTrajetoPai(t.getTrajetoPai() == null ? null : t.getTrajetoPai().getId());
				
				GoogleMapResponse gr = new GoogleMapResponse();
				gr.setId(t.getGoogleMap().getId());
				gr.setLatitudeFinal(t.getGoogleMap().getLatitudeFinal());
				gr.setLatitudeInicial(t.getGoogleMap().getLatitudeInicial());
				gr.setLongitudeFinal(t.getGoogleMap().getLongitudeFinal());
				gr.setLongitudeInicial(t.getGoogleMap().getLongitudeInicial());
				
				for(WayPoint w : t.getGoogleMap().getWayPoints()){
					WayPointResponse wr = new WayPointResponse();
					wr.setLatitude(w.getLatitude());
					wr.setLongitude(w.getLongitude());
					wr.setOrdem(w.getOrdem());
					gr.getWayPoints().add(wr);
				}
				tr.setGoogleMap(gr);
				rr.getTrajetos().add(tr);
			}
		
			roteirosResponse.add(rr);
		}
		
		return roteirosResponse;
	}

	

}
