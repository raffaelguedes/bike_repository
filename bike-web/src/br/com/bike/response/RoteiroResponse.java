package br.com.bike.response;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bike.modelo.Status;

@XmlRootElement
public class RoteiroResponse {

	private Long id;

	private String descricao;

	private Status status;

	private Calendar dataCriacao;
	
	private Set<ParticipanteResponse> participantes = new HashSet<ParticipanteResponse>();
	
	private Set<TrajetoResponse> trajetos = new HashSet<TrajetoResponse>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Set<ParticipanteResponse> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<ParticipanteResponse> participantes) {
		this.participantes = participantes;
	}

	public Set<TrajetoResponse> getTrajetos() {
		return trajetos;
	}

	public void setTrajetos(Set<TrajetoResponse> trajetos) {
		this.trajetos = trajetos;
	}
	
	
}
