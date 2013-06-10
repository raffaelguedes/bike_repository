package br.com.bike.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class GoogleMap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String latitudeInicial;
	
	private String longitudeInicial;
	
	private String latitudeFinal;
	
	private String longitudeFinal;
	
	@OneToMany(mappedBy="googleMap", fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private Set<WayPoint> wayPoints = new HashSet<WayPoint>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLatitudeInicial() {
		return latitudeInicial;
	}

	public void setLatitudeInicial(String latitudeInicial) {
		this.latitudeInicial = latitudeInicial;
	}

	public String getLongitudeInicial() {
		return longitudeInicial;
	}

	public void setLongitudeInicial(String longitudeInicial) {
		this.longitudeInicial = longitudeInicial;
	}

	public String getLatitudeFinal() {
		return latitudeFinal;
	}

	public void setLatitudeFinal(String latitudeFinal) {
		this.latitudeFinal = latitudeFinal;
	}

	public String getLongitudeFinal() {
		return longitudeFinal;
	}

	public void setLongitudeFinal(String longitudeFinal) {
		this.longitudeFinal = longitudeFinal;
	}

	public Set<WayPoint> getWayPoints() {
		return wayPoints;
	}

	public void setWayPoints(Set<WayPoint> wayPoints) {
		this.wayPoints = wayPoints;
	}
	
}
