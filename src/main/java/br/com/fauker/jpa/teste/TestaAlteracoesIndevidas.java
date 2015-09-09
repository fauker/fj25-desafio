package br.com.fauker.jpa.teste;

import javax.persistence.EntityManager;

import br.com.fauker.jpa.domain.Conta;
import br.com.fauker.jpa.util.JPAUtil;

public class TestaAlteracoesIndevidas {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
//		Conta conta = manager.find(Conta.class, 1L);
		
		Conta conta = manager.getReference(Conta.class, 1L);
		
		//ambos colocam o objeto no estado MANAGED.
	
		System.out.println(conta.toString());
		
		conta.setTitular("Lucas Moreira 2");
		
		manager.getTransaction().commit();
		
		manager.close();
		
	}
}
