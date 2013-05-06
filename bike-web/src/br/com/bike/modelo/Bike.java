package br.com.bike.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bike {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer anoModelo;
	
	private String cor;
	
	@Enumerated(EnumType.STRING)
	private TipoBike tipoBike;
	
	@ManyToOne
	private Modelo modelo;
}
