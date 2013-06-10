package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bike.modelo.TipoBike;

@XmlRootElement
public class BikeResponse {

	private Long id;
	
	private Long perfilID;
	
	private Integer anoModelo;
	
	private String cor;
	
	private TipoBike tipoBike;
	
	private ModeloResponse modelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPerfilID() {
		return perfilID;
	}

	public void setPerfilID(Long perfilID) {
		this.perfilID = perfilID;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TipoBike getTipoBike() {
		return tipoBike;
	}

	public void setTipoBike(TipoBike tipoBike) {
		this.tipoBike = tipoBike;
	}

	public ModeloResponse getModelo() {
		return modelo;
	}

	public void setModelo(ModeloResponse modelo) {
		this.modelo = modelo;
	}
	
}
