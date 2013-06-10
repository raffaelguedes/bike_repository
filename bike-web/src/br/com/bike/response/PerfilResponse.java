package br.com.bike.response;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.com.bike.modelo.Status;
import br.com.bike.modelo.TipoPerfil;

public class PerfilResponse {
	private Long id;

	private String pensamento;

	private String foto;
	
	private UsuarioResponse usuario;
	
	private TipoPerfil tipoPerfil;
	
	private Set<EnderecoResponse> enderecos = new HashSet<EnderecoResponse>();
	
	private Set<TelefoneResponse> telefones = new HashSet<TelefoneResponse>();
	
	private Set<BikeResponse> bikes = new HashSet<BikeResponse>();
	
	private Status status;
	
	private Calendar dataCriacao;
	
	private Calendar dataUltimoAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPensamento() {
		return pensamento;
	}

	public void setPensamento(String pensamento) {
		this.pensamento = pensamento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public UsuarioResponse getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResponse usuario) {
		this.usuario = usuario;
	}

	public TipoPerfil getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(TipoPerfil tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public Set<EnderecoResponse> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<EnderecoResponse> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<TelefoneResponse> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<TelefoneResponse> telefones) {
		this.telefones = telefones;
	}

	public Set<BikeResponse> getBikes() {
		return bikes;
	}

	public void setBikes(Set<BikeResponse> bikes) {
		this.bikes = bikes;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Calendar dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}
	
	

}
