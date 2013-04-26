package br.com.bike.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

/**
 * Classe que representa o trajeto percorrido por cada participante.
 * @author Raffa
 *
 */
@Entity
public class Trajeto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Indica se o trajeto é Ida, Volta etc...
	 */
	@ManyToOne
	private TipoTrajeto tipoTrajeto;
	
	/**
	 * Auto Relacionamento com o trajeto pai
	 */
	@ManyToOne
	private Trajeto trajetoPai;
	
	@ManyToOne
	private Perfil perfil;
	
	private DateTime dataInicioTrajeto;
	
	private DateTime dataFimTrajeto;
	
	//TODO Atributos ou Objetos que representam o dado do gps.
}
