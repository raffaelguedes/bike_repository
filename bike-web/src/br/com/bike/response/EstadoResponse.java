package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstadoResponse {

	private Long id;
	
	private String nome;
	
	private PaisResponse pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PaisResponse getPais() {
		return pais;
	}

	public void setPais(PaisResponse pais) {
		this.pais = pais;
	}
	
	
}
