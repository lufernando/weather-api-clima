package br.com.cast.weather.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {

	@JsonProperty("main")
	private WeatherMainDTO main;
	
	@JsonProperty("weather")
	private List<WeatherDescriptionDTO> weatherDescriptionDTO;
	
	@JsonProperty("wind")
	private WeatherWindDTO wind;
	
	@JsonProperty("dt_txt")
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public WeatherMainDTO getMain() {
		return main;
	}

	public void setMain(WeatherMainDTO main) {
		this.main = main;
	}

	public List<WeatherDescriptionDTO> getWeatherDescriptionDTO() {
		return weatherDescriptionDTO;
	}

	public void setWeatherDescriptionDTO(List<WeatherDescriptionDTO> weatherDescriptionDTO) {
		this.weatherDescriptionDTO = weatherDescriptionDTO;
	}

	public WeatherWindDTO getWind() {
		return wind;
	}

	public void setWind(WeatherWindDTO wind) {
		this.wind = wind;
	}
	
	
	
}
