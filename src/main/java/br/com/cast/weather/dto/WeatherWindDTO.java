package br.com.cast.weather.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherWindDTO {
	
	private String velocidade;
	
	@JsonCreator
	public WeatherWindDTO(@JsonProperty("speed") String velocidade) {
		this.velocidade = velocidade;
	}

	public String getVelocidade() {
		return velocidade;
	}

}
