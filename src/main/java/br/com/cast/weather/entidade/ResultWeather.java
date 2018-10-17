package br.com.cast.weather.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tempo", schema="apiclima")
public class ResultWeather {
	
	@Id
	@SequenceGenerator(name = "generator", schema = "apiclima", sequenceName = "tempo_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String cidade;
	
	@Column(name="tempmin")
	private String tempMin;
	
	@Column(name="tempmax")
	private String tempMax;
	
	private String umidade;
	private String pressao;
	
	private Date data = new Date();
	private String velocidade;
	
	@Column(name="main")
	private String main;
	
	private String icone;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
