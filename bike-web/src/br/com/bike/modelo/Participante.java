package br.com.bike.modelo;

import java.util.Calendar;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Participante {

	@EmbeddedId
	private ParticipanteId participanteId;

	@Enumerated(EnumType.STRING)
	private TipoParticipacao tipoParticipacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicioParticipacao;

	@Enumerated(EnumType.STRING)
	private Status status;

	public ParticipanteId getParticipanteId() {
		if(participanteId == null){
			participanteId = new ParticipanteId();
		}
		return participanteId;
	}

	public void setParticipanteId(ParticipanteId participanteId) {
		this.participanteId = participanteId;
	}

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


}
