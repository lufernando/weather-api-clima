package br.com.cast.weather.dto;

public class ResultWeatherDTO {

	private String cidade;
	private String tempMin;
	private String tempMax;
	private String umidade;
	private String pressao;
	private String data;
	private String velocidade;
	private String main;
	private String icone;
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTempMin() {
		return tempMin;
	}

	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}

	public String getTempMax() {
		return tempMax;
	}

	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	
	
	
}
