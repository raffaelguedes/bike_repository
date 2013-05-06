package br.com.bike.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe que representa os trajetos e participantes.
 * @author Raffa
 *
 */
@Entity
public class Roteiro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@OneToMany(mappedBy="participanteId.roteiro")
	private List<Participante> participantes;
	
	@OneToMany
	private List<Trajeto> trajetos;
	
	@Enumerated(EnumType.STRING)
	private Status status;
}
