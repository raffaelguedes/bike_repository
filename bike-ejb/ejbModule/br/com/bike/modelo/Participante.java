package br.com.bike.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.joda.time.DateTime;

@Entity
public class Participante {

	@EmbeddedId
	private ParticipanteId participanteId;
	
	@Enumerated(EnumType.STRING)
	private TipoParticipacao tipoParticipacao;
	
	private DateTime dataInicioParticipacao;

	@Enumerated(EnumType.STRING)
	private Status status;
}
