package br.com.cast.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.weather.dto.ResultWeatherDTO;
import br.com.cast.weather.service.PrevisaoService;

@RestController
@RequestMapping(path="/previsao")
public class PrevisaoAPI {
	
	@Autowired
	private PrevisaoService service;
	
	@GetMapping
	public List<ResultWeatherDTO> getCincoDias(@RequestParam("q") String cidade) {
		return service.getPrevisoes(cidade);
	}
	
}
