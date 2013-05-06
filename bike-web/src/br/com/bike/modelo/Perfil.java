package br.com.bike.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

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
	
	@OneToMany
	private List<Endereco> enderecos;
	
	@OneToMany
	private List<Telefone> telefones;
	
	@OneToMany
	private List<Bike> bikes;
	
	//TODO COMO REPRESENTAR COM O HIBERNATE
	//LISTA COM TODOS OS ROTEIROS ASSINADOS PELO PERFIL
	//private List<Roteiro> roteiros;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private DateTime dataCriacao;
	
	private DateTime dataUltimoAcesso;
}
