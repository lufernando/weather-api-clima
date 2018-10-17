package br.com.cast.weather.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.weather.client.OpenWeatherClient;
import br.com.cast.weather.dto.ResultWeatherDTO;
import br.com.cast.weather.dto.WeatherDTO;
import br.com.cast.weather.dto.WeatherDataDTO;
import br.com.cast.weather.dto.WeatherDescriptionDTO;
import br.com.cast.weather.entidade.ResultWeather;
import br.com.cast.weather.repository.WeatherRepository;

@Service
public class PrevisaoService {

	@Autowired
	private OpenWeatherClient openWeatherClient;

	@Autowired
	private WeatherRepository weatherRepository;

	public List<ResultWeatherDTO> getPrevisoes(String cidade) {

		List<ResultWeather> resultadoEntidade = weatherRepository.buscarTodos(cidade);
		List<ResultWeatherDTO> resultado = new ArrayList<>();

		if (resultadoEntidade.size() < 5) {
			
			if(!resultadoEntidade.isEmpty()) {				
				weatherRepository.excluirPorCidade(cidade);
			}
			
			Map<String, ResultWeatherDTO> map = new HashMap<>();
			WeatherDTO previsoes = openWeatherClient.getPrevisoes(cidade);
			
			for (WeatherDataDTO data : previsoes.getList()) {
				String dataMap = data.getData().substring(0, 10);
				if (map.containsKey(dataMap)) {
					continue;
				}
				
				ResultWeatherDTO result = converteApiParaDTO(cidade, data);
				map.put(dataMap, result);
				resultado.add(result);
				inserir(result);
			}
			
		} else {
			
			for (ResultWeather resultWeather : resultadoEntidade) {
				ResultWeatherDTO result = converteEntidadeParaDTO(cidade, resultWeather);
				resultado.add(result);
			}
			
		}
		return resultado;
	}

	public ResultWeatherDTO converteEntidadeParaDTO(String cidade, ResultWeather resultWeather) {
		ResultWeatherDTO result = new ResultWeatherDTO();
		result.setCidade(cidade);
		result.setTempMin(resultWeather.getTempMin());
		result.setTempMax(resultWeather.getTempMax());
		result.setUmidade(resultWeather.getUmidade());
		result.setPressao(resultWeather.getPressao());
		result.setData(DateParaString(resultWeather.getData()));
		result.setVelocidade(resultWeather.getVelocidade());
		result.setMain(resultWeather.getMain());
		result.setIcone(resultWeather.getIcone());
		return result;
	}

	public ResultWeatherDTO converteApiParaDTO(String cidade, WeatherDataDTO data) {
		ResultWeatherDTO result = new ResultWeatherDTO();
		result.setCidade(cidade);
		result.setTempMin(data.getMain().getTempMin());
		result.setTempMax(data.getMain().getTempMax());
		result.setUmidade(data.getMain().getUmidade());
		result.setPressao(data.getMain().getPressao());
		result.setData(data.getData());
		result.setVelocidade(data.getWind().getVelocidade());
		for (WeatherDescriptionDTO wd : data.getWeatherDescriptionDTO()) {
			result.setMain(wd.getMain());
			result.setIcone(wd.getIcone());
		}
		return result;
	}

	public void inserir(ResultWeatherDTO rwDTO) {


			ResultWeather rwEntidade = new ResultWeather();
			rwEntidade.setCidade(rwDTO.getCidade());
			rwEntidade.setTempMax(rwDTO.getTempMax());
			rwEntidade.setTempMin(rwDTO.getTempMin());
			rwEntidade.setData(StringParaDate(rwDTO.getData()));
			rwEntidade.setIcone(rwDTO.getIcone());
			rwEntidade.setMain(rwDTO.getMain());
			rwEntidade.setPressao(rwDTO.getPressao());
			rwEntidade.setUmidade(rwDTO.getUmidade());
			rwEntidade.setVelocidade(rwDTO.getVelocidade());

			weatherRepository.inserir(rwEntidade);
	}
	
	/*METODOS DE CONVERSÃO DATA*/
	
	public Date StringParaDate(String data) {
		Date dataFormatada = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
	
	public String DateParaString(Date date) {
		String dataFormatada = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}

}
