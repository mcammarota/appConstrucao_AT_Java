package br.edu.infnet.appConstrucao.model.tests;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		Acabamento a1 = new Acabamento("Acabamento do projeto", 100, 90);
		a1.setPiso("porcelanato");
		a1.setPintura("acetinada");
		a1.setRodape(true);
		System.out.println("Produto: " + a1);
		
		Estrutura e1 = new Estrutura("Estrutura do projeto", 200, 30);
		e1.setDescricao("Concreto armado convencional");
		e1.setTamanho_ferragem(10);
		e1.setMetalica(false);
		System.out.println("Produto: " + e1);
		
		Fundacao f1 = new Fundacao("Fundação do projeto", 300, 45);
		f1.setFundacaoRasa(true);
		f1.setTipo("radier");
		f1.setProfundidade(2);
		System.out.println("Produto: " + f1);
	}
}
