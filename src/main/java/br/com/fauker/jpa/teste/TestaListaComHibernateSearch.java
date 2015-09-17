package br.com.fauker.jpa.teste;

import java.util.List;

import br.com.fauker.jpa.dao.ContaDao;
import br.com.fauker.jpa.domain.Conta;
import br.com.fauker.jpa.util.JPAUtil;

public class TestaListaComHibernateSearch {

	public static void main(String[] args) {
		ContaDao dao = new ContaDao(new JPAUtil().getEntityManager());
		
		List<Conta> contas = dao.listaComHibernateSearch("Jaumzin");
		
		for (Conta conta : contas) {
			System.out.println(conta.getTitular());
		}
	}
	
}
