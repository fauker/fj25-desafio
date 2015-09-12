package br.com.fauker.jpa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;
	private String titular;
	private String numero;
	private String agencia;
	
	@OneToMany(mappedBy = "conta") 
	private List<Movimentacao> movimentacoes;
	
//	@OneToMany
//	@JoinColumn(name = "id_conta")
//	private List<Movimentacao> movimentacoes;
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Titular " + this.titular +" - Conta: " + this.numero + " - Agencia: " + this.agencia;
 	}
	
}
