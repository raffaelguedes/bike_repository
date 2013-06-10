package br.com.bike.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	 * Indica se o trajeto é Ida, Volta ou mestre etc...
	 */
	@Enumerated(EnumType.STRING)
	private TipoTrajeto tipoTrajeto;
	
	/**
	 * Auto Relacionamento com o trajeto pai
	 */
	@ManyToOne
	private Trajeto trajetoPai;
	
	@ManyToOne
	private Perfil perfil;
	
	@ManyToOne
	private Roteiro roteiro;
	
	@OneToOne
	private GoogleMap googleMap;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicioTrajeto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFimTrajeto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTrajeto getTipoTrajeto() {
		return tipoTrajeto;
	}

	public void setTipoTrajeto(TipoTrajeto tipoTrajeto) {
		this.tipoTrajeto = tipoTrajeto;
	}

	public Trajeto getTrajetoPai() {
		return trajetoPai;
	}

	public void setTrajetoPai(Trajeto trajetoPai) {
		this.trajetoPai = trajetoPai;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	public GoogleMap getGoogleMap() {
		return googleMap;
	}

	public void setGoogleMap(GoogleMap googleMap) {
		this.googleMap = googleMap;
	}

	public Calendar getDataInicioTrajeto() {
		return dataInicioTrajeto;
	}

	public void setDataInicioTrajeto(Calendar dataInicioTrajeto) {
		this.dataInicioTrajeto = dataInicioTrajeto;
	}

	public Calendar getDataFimTrajeto() {
		return dataFimTrajeto;
	}

	public void setDataFimTrajeto(Calendar dataFimTrajeto) {
		this.dataFimTrajeto = dataFimTrajeto;
	}

	
}
