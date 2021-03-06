package br.com.bike.modelo;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String pensamento;
	
	private String foto;
	
	@OneToOne
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	private TipoPerfil tipoPerfil;
	
	@OneToMany(mappedBy="perfil", fetch=FetchType.EAGER)
	private Set<Endereco> enderecos = new HashSet<Endereco>();
	
	@OneToMany(mappedBy="perfil", fetch=FetchType.EAGER)
	private Set<Telefone> telefones = new HashSet<Telefone>();
	
	@OneToMany(mappedBy="perfil", fetch=FetchType.EAGER)
	private Set<Bike> bikes = new HashSet<Bike>();
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoPerfil getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(TipoPerfil tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Set<Bike> bikes) {
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
