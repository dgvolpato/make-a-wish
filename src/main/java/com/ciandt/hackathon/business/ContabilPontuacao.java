package com.ciandt.hackathon.business;

import com.ciandt.hackathon.dao.CompraDAO;
import com.ciandt.hackathon.dao.PontuacaoDAO;
import com.ciandt.hackathon.entity.Compra;
import com.ciandt.hackathon.entity.Pontuacao;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ContabilPontuacao {

	@Inject
	CompraDAO compraDAO;
	@Inject
	PontuacaoDAO pontuacaoDAO;
	@Inject
	ContabilBadge contabilBadge;

	public void efetuaCompra(Compra compra) {
		if (compra.getItem() != null) {
			compra.setNumeroPontos(compra.getItem().getPreco().longValue());
			compraDAO.insertCompra(compra);
			this.enviaAprovacao(compra);
		} else {
			throw new IllegalArgumentException(
					"Compra invalida! Item esta nulo");
		}

	}

	public void enviaAprovacao(Compra compra) {
		// Envia para um sistema de aprovacao de auditoria. O sistema
		// responderia no efetiva Compra.
		compra.setAprovada(true);
		this.efetivaCompra(compra);

	}

	public void efetivaCompra(Compra compra) {
		if (compra.getAprovada()) {
			if (!(compra.getPessoa() != null)) {
				//Pega a pontuacao da mesa
				Pontuacao pontuacao = (Pontuacao) pontuacaoDAO.findPontuacaoPorMesa(compra.getPessoa().getMesa());
				if(pontuacao == null){
					pontuacao = new Pontuacao();
					pontuacao.setMesa(compra.getPessoa().getMesa());
					pontuacao.setNumeroPontos(0l);
				}
				pontuacao.setNumeroPontos(compra.getNumeroPontos());
				contabilBadge.calcularBadge(pontuacao);
			}else{
				throw new IllegalArgumentException("Compra sem pessoa! Nao pode ser efetivada");
			}
		}
	}
}