package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CidadeResponse {
	
	private Long id;
	
	private String descricao;
	
	private EstadoResponse estado;

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

	public EstadoResponse getEstado() {
		return estado;
	}

	public void setEstado(EstadoResponse estado) {
		this.estado = estado;
	}
}
