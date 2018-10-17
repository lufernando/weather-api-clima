package br.com.cast.weather.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cast.weather.entidade.ResultWeather;

@Repository
public class WeatherRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void inserir(ResultWeather rw) {
		em.persist(rw);
	}

	@SuppressWarnings("unchecked")
	public List<ResultWeather> buscarTodos(String cidade){

		StringBuilder jpql = new StringBuilder();

		jpql.append("FROM ")
			.append(ResultWeather.class.getName())
			.append(" WHERE cidade = (:cidade) and data >= (:data)");
		Query query = em.createQuery(jpql.toString());

		query.setParameter("cidade", cidade);
		query.setParameter("data", new Date());

		return query.getResultList();
	}
	
	@Transactional
	public void excluirPorCidade(String cidade) {
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("DELETE ")
			.append("FROM ").append(ResultWeather.class.getName())
			.append(" WHERE cidade = (:cidade) ");
		Query query = em.createQuery(jpql.toString());
		
		query.setParameter("cidade", cidade);
		query.executeUpdate();
		
	}
	
	

}
