package br.edu.infnet.appConstrucao.model.tests;

import br.edu.infnet.appConstrucao.model.domain.Empresa;

public class EmpresaTeste {

	public static void main(String[] args) {
		
		Empresa e1 = new Empresa("Marcos Cammarota", "marcoscammarota@hotmail.com", "(21) 99999-9999");
		System.out.println("Empresa: " + e1);
	}
}
