package br.com.fauker.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fauker.jpa.dao.ContaDao;
import br.com.fauker.jpa.dao.MovimentacaoDao;
import br.com.fauker.jpa.domain.Conta;
import br.com.fauker.jpa.domain.Movimentacao;
import br.com.fauker.jpa.enums.TipoMovimentacao;
import br.com.fauker.jpa.util.JPAUtil;

public class TestaInsereMovimentacao {
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
		ContaDao contaDao = new ContaDao(em);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		
		Conta conta = new Conta();
		conta.setAgencia("1234-5");
		conta.setNumero("12345-6");
		conta.setTitular("Joãozinho da Kombi");
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		
		contaDao.adiciona(conta);
		movimentacaoDao.adiciona(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
