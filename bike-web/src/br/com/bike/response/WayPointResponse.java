package br.com.bike.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WayPointResponse {
	private Integer ordem;

	private String latitude;

	private String longitude;

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
}
