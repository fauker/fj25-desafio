package br.com.fauker.jpa.teste;

import javax.persistence.EntityManager;

import br.com.fauker.jpa.dao.ContaDao;
import br.com.fauker.jpa.domain.Conta;
import br.com.fauker.jpa.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(em);
		
		Conta conta = new Conta();
		conta.setAgencia("3413-4");
		conta.setNumero("32319-5");
		conta.setTitular("Lucas Moreira");
		
		em.getTransaction().begin();
		
		dao.adiciona(conta);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
}
