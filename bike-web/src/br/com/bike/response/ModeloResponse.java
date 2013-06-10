package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModeloResponse {
	
	private Long id;
	
	private String descricao;
	
	private MarcaResponse marca;

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

	public MarcaResponse getMarca() {
		return marca;
	}

	public void setMarca(MarcaResponse marca) {
		this.marca = marca;
	}
}
