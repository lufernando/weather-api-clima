package br.com.cast.weather.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.weather.dto.WeatherDTO;

@Component
public class OpenWeatherClient {
	private static final String URL_BUSCA_PREVISOES = 
			"http://api.openweathermap.org/data/2.5/forecast?q={cidade},br&"
			+ "units=metric&mode=json&appid={appid}&lang=pt";
	private static final String APPID = "bf6fd4cd095b73d4e081d9ea308b68f9";
	private RestTemplate client;
	
	public OpenWeatherClient(RestTemplateBuilder builder) {
		this.client = builder.build();
	}
	
	public WeatherDTO getPrevisoes(String cidade) {
		WeatherDTO dto = this.client.getForObject(URL_BUSCA_PREVISOES, 
				WeatherDTO.class, cidade, APPID);
		return dto;
	}

}
