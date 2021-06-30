package br.edu.infnet.appConstrucao.model.tests;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;
import br.edu.infnet.appConstrucao.model.exceptions.NecessitaFundacaoProfundaException;
import br.edu.infnet.appConstrucao.model.exceptions.PisoNuloException;
import br.edu.infnet.appConstrucao.model.exceptions.TamanhoFerragemZeradaOuNegativaException;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		try {
			Acabamento a1 = new Acabamento("Acabamento do 1º projeto", 1000, 90);
			a1.setPiso("porcelanato");
			a1.setPintura("acetinada");
			a1.setRodape(true);
			System.out.printf("Produto -> %s", a1.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Acabamento a2 = new Acabamento("Acabamento do 2º projeto", 800, 80);
			a2.setPiso("cerâmica");
			a2.setPintura("acrílica");
			a2.setRodape(false);
			System.out.printf("Produto -> %s", a2.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		// Exception no piso
		try {
			Acabamento a3 = new Acabamento("Acabamento do 3º projeto", 500, 70);
			a3.setPiso("");
			a3.setPintura("acrílica");
			a3.setRodape(true);
			System.out.printf("Produto -> %s", a3.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Estrutura e1 = new Estrutura("Estrutura do 1º projeto", 400, 30);
			e1.setDescricao("Concreto armado convencional");
			e1.setTamanho_ferragem(10);
			e1.setMetalica(false);
			System.out.printf("Produto -> %s", e1.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Estrutura e1 = new Estrutura("Estrutura do 2º projeto", 700, 25);
			e1.setDescricao("Concreto armado convencional");
			e1.setTamanho_ferragem(12);
			e1.setMetalica(true);
			System.out.printf("Produto -> %s", e1.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		// Exception na ferragem
		try {
			Estrutura e3 = new Estrutura("Estrutura do 3º projeto", 200, 25);
			e3.setDescricao("Concreto armado convencional");
			e3.setTamanho_ferragem(0);
			e3.setMetalica(true);
			System.out.printf("Produto -> %s", e3.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fundacao f1 = new Fundacao("Fundação do 1º projeto", 500, 45);
			f1.setFundacaoRasa(true);
			f1.setTipo("radier");
			f1.setProfundidade(2);
			System.out.printf("Produto -> %s", f1.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fundacao f2 = new Fundacao("Fundação do 2º projeto", 600, 45);
			f2.setFundacaoRasa(false);
			f2.setTipo("estaca");
			f2.setProfundidade(10);
			System.out.printf("Produto -> %s", f2.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
		
		// Exception com fundação rasa > 3m
		try {
			Fundacao f3 = new Fundacao("Fundação do 3º projeto", 300, 45);
			f3.setFundacaoRasa(true);
			f3.setTipo("sapa corrida");
			f3.setProfundidade(4);
			System.out.printf("Produto -> %s", f3.obterProduto());
		} catch (PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
			System.out.println(e.getMessage());
		}
	}
}
