package br.com.bike.response;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.Status;
import br.com.bike.modelo.TipoParticipacao;

@XmlRootElement
public class ParticipanteResponse {

	private TipoParticipacao tipoParticipacao;
	
	private Calendar dataInicioParticipacao;
	
	private Status status;
	
	private Perfil perfil;

	public TipoParticipacao getTipoParticipacao() {
		return tipoParticipacao;
	}

	public void setTipoParticipacao(TipoParticipacao tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

	public Calendar getDataInicioParticipacao() {
		return dataInicioParticipacao;
	}

	public void setDataInicioParticipacao(Calendar dataInicioParticipacao) {
		this.dataInicioParticipacao = dataInicioParticipacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
