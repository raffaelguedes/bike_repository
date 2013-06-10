package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TelefoneResponse {

	private Long id;
	
	private Integer ddd;
	
	private Integer numero;
	
	private OperadoraResponse operadora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public OperadoraResponse getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraResponse operadora) {
		this.operadora = operadora;
	}
	
	
}
