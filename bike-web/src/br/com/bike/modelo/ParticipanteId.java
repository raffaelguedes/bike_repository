package br.com.bike.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ParticipanteId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Perfil perfil;
	
	@ManyToOne
	private Roteiro roteiro;
	
	
}
