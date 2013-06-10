package br.com.bike.response;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bike.modelo.Perfil;
import br.com.bike.modelo.TipoTrajeto;

@XmlRootElement
public class TrajetoResponse {

	private Long id;
	
	private TipoTrajeto tipoTrajeto;
	
	private Long trajetoPai;
	
	private Calendar dataInicioTrajeto;
	
	private Calendar dataFimTrajeto;
	
	private Perfil perfil;
	
	private GoogleMapResponse googleMap;

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

	public Long getTrajetoPai() {
		return trajetoPai;
	}

	public void setTrajetoPai(Long trajetoPai) {
		this.trajetoPai = trajetoPai;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public GoogleMapResponse getGoogleMap() {
		return googleMap;
	}

	public void setGoogleMap(GoogleMapResponse googleMap) {
		this.googleMap = googleMap;
	}
	
	
}
