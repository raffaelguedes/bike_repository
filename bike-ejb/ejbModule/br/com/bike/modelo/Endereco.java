package br.com.bike.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String logradouro;
	
	private Integer numero;
	
	private String complemento;
	
	private String bairro;
	
	private Integer cep;
	
	@ManyToOne
	private Cidade cidade;
	
	/**
	 * RESIDENCIA, FACULDADE, EMPRESA...
	 */
	@ManyToOne
	private TipoEndereco tipoEndereco;
	
	@Enumerated(EnumType.STRING)
	private Status status;
}
