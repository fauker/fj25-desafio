package br.com.fauker.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

import br.com.fauker.jpa.domain.Conta;

public class ContaDao {

	private EntityManager em;

	public ContaDao(EntityManager em) {
		this.em = em;
	}
	
	public void adiciona(Conta conta) {
		if (conta.getId() != null) conta = this.em.merge(conta);
		this.em.persist(conta);
	}
	
	public void remove(Conta conta) {
		this.em.remove(conta);
	}
	
	public List<Conta> lista() {
		return this.em.createQuery("select c from Conta c", Conta.class).getResultList();
	}
		
	public List<Conta> listaComCriteriaHibernate() {
		Session session = this.em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Conta.class);
		return criteria.list();
	}
	
	public List<Conta> listaComUaiCriteria() {
		UaiCriteria<Conta> uaiCriteria = UaiCriteriaFactory.createQueryCriteria(this.em, Conta.class);
		return uaiCriteria.getResultList();
	}
	
	public List<Conta> listaComCriteriaJPA() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Conta> query = builder.createQuery(Conta.class);
		Root<Conta> from = query.from(Conta.class);
		CriteriaQuery<Conta> select = query.select(from);
		
		TypedQuery<Conta> typedQuery = this.em.createQuery(select);
		return typedQuery.getResultList();
	}
	
	public List<Conta> listaComHibernateSearch(String titular) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.em);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Conta.class).get();
		Query luceneQuery = queryBuilder.keyword().onField("titular").matching(titular).createQuery();
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Conta.class);
		List contas = jpaQuery.getResultList();
		return contas;
	}
}
