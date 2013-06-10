package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnderecoResponse {
	
	private Long id;
	
	private Long perfilID;
	
	private String logradouro;
	
	private Integer numero;
	
	private String complemento;
	
	private String bairro;
	
	private Integer cep;
	
	private CidadeResponse cidade;

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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public CidadeResponse getCidade() {
		return cidade;
	}

	public void setCidade(CidadeResponse cidade) {
		this.cidade = cidade;
	}
	
	
}
