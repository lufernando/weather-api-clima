package br.com.cast.weather.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDescriptionDTO {

	private String main;
	private String icone;
	
	@JsonCreator
	public WeatherDescriptionDTO(@JsonProperty("main") String main, 
			@JsonProperty("icon") String icone) {
		this.main = main;
		this.icone = icone;
	}
	
	public String getMain() {
		return main;
	}
	
	public String getIcone() {
		return icone;
	}
	

}
