package br.edu.infnet.appConstrucao.model.tests;

import br.edu.infnet.appConstrucao.model.domain.Cotacao;
import br.edu.infnet.appConstrucao.model.domain.Empresa;

public class CotacaoTeste {

	public static void main(String[] args) {
		
		Empresa empresaE1 = new Empresa("Marcos", "marcos@marcos.com", "(21) 99999-9999");
		
		Cotacao c1 = new Cotacao();
		c1.setDescricao("Outro pedido");
		c1.setEmpresa(empresaE1);
		System.out.println("Cotação: " + c1);
		
		Cotacao c2 = new Cotacao("Cotação do Marcos");
		c1.setEmpresa(null);
		System.out.println("Cotação: " + c2);
	}
}
