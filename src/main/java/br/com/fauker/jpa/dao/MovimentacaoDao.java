package br.com.fauker.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fauker.jpa.domain.Movimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}
	
	public void adiciona(Movimentacao movimentacao) {
		if (movimentacao.getId() != null) movimentacao = this.em.merge(movimentacao);
		this.em.persist(movimentacao);
	}

	@SuppressWarnings("unchecked")
	public List<Movimentacao> lista() {
		return this.em.createQuery("select m from Movimentacao m").getResultList();
	}
	
}
