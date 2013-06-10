package br.com.bike.response;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoogleMapResponse {

	private Long id;

	private String latitudeInicial;

	private String longitudeInicial;

	private String latitudeFinal;

	private String longitudeFinal;

	private Set<WayPointResponse> wayPoints = new HashSet<WayPointResponse>();

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

	public Set<WayPointResponse> getWayPoints() {
		return wayPoints;
	}

	public void setWayPoints(Set<WayPointResponse> wayPoints) {
		this.wayPoints = wayPoints;
	}
	
	
}
