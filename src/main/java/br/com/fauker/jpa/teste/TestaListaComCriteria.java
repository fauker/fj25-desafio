package br.com.fauker.jpa.teste;

import javax.persistence.EntityManager;

import br.com.fauker.jpa.dao.ContaDao;
import br.com.fauker.jpa.domain.Conta;
import br.com.fauker.jpa.util.JPAUtil;

public class TestaListaComCriteria {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(em);
		
		for (Conta conta : dao.listaComCriteriaHibernate()) {
			System.out.println(conta.toString());
		}
	}
}
