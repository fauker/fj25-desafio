package br.com.fauker.jpa.teste;

import javax.persistence.EntityManager;

import br.com.fauker.jpa.dao.MovimentacaoDao;
import br.com.fauker.jpa.domain.Movimentacao;
import br.com.fauker.jpa.util.JPAUtil;

public class TestaListaMovimentacao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		for (Movimentacao movimentacao : dao.lista()) {
			System.out.println(movimentacao.toString());
		}
	}
}
