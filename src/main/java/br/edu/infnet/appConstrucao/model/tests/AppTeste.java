package br.edu.infnet.appConstrucao.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Cotacao;
import br.edu.infnet.appConstrucao.model.domain.Empresa;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;
import br.edu.infnet.appConstrucao.model.exceptions.NecessitaFundacaoProfundaException;
import br.edu.infnet.appConstrucao.model.exceptions.PisoNuloException;
import br.edu.infnet.appConstrucao.model.exceptions.TamanhoFerragemZeradaOuNegativaException;

public class AppTeste {

	public static void main(String[] args) {
		
		try {
			String dir = "C:/Users/Cammarota/eclipse-workspace/appConstrucao/";
			String arq = "cotacoes.txt";
			
			try {
				
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);

				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);
				String linha = leitura.readLine();

				while(linha != null) {
					String[] campos = linha.split(";");


					switch(campos[0].toUpperCase()) {
					
					case "0":
						Empresa empresaE1 = new Empresa(campos[2], campos[3], campos[4]);
						
						Cotacao c1 = new Cotacao();
						c1.setDescricao(campos[1]);
						c1.setEmpresa(empresaE1);
					
						System.out.println(c1);
						
						break;
						
					case "A":
						Acabamento a1 = new Acabamento(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[3]));
						a1.setPiso(campos[4]);
						a1.setPintura(campos[5]);
						a1.setRodape("S".equalsIgnoreCase(campos[6]));
						
						escrita.write(a1.obterProduto());
						
						break;

					case "E":
						Estrutura e1 = new Estrutura(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[3]));
						e1.setDescricao(campos[4]);
						e1.setTamanhoFerragem(Float.valueOf(campos[5]));
						e1.setMetalica("S".equalsIgnoreCase(campos[6]));
						
						escrita.write(e1.obterProduto());
						
						break;

					case "F":
						Fundacao f1 = new Fundacao(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[3]));
						f1.setFundacaoRasa("S".equalsIgnoreCase(campos[4]));
						f1.setTipo(campos[5]);
						f1.setProfundidade(Float.valueOf(campos[6]));
						
						escrita.write(f1.obterProduto());
						
						break;

					default:
						System.out.println("Entrada inválida!");
						break;
					}

					linha = leitura.readLine();
				}

				file.close();
				leitura.close();
				escrita.close();
				fileW.close();
				
			} catch (IOException | PisoNuloException | TamanhoFerragemZeradaOuNegativaException | NecessitaFundacaoProfundaException e) {
				System.out.println(e.getMessage());
			}

			} finally {
				System.out.println("Processamento finalizado!");
			}
	}
}

