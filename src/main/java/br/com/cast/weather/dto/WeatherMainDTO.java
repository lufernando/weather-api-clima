package br.com.cast.weather.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMainDTO {

	private String tempMin;
	private String tempMax;
	private String pressao;
	private String umidade;
	
	@JsonCreator
	public WeatherMainDTO(@JsonProperty("temp_min") String tempMin, 
			@JsonProperty("temp_max") String tempMax, 
			@JsonProperty("pressure") String pressao, 
			@JsonProperty("humidity") String umidade) {
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.pressao = pressao;
		this.umidade = umidade;
	}

	public String getTempMin() {
		return tempMin;
	}

	public String getTempMax() {
		return tempMax;
	}

	public String getPressao() {
		return pressao;
	}

	public String getUmidade() {
		return umidade;
	}

}
