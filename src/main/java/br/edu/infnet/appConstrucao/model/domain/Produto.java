package br.edu.infnet.appConstrucao.model.domain;

import br.edu.infnet.appConstrucao.model.exceptions.NecessitaFundacaoProfundaException;
import br.edu.infnet.appConstrucao.model.exceptions.PisoNuloException;
import br.edu.infnet.appConstrucao.model.exceptions.TamanhoFerragemZeradaException;

public abstract class Produto {

	private String descricao;
	private float valor;
	private int prazoEntrega;
	
	public Produto(String descricao, float valor, int prazoEntrega) {
		this.descricao = descricao;
		this.valor = valor;
		this.prazoEntrega = prazoEntrega;
	}
	
	public String getProduto() throws TamanhoFerragemZeradaException, PisoNuloException, NecessitaFundacaoProfundaException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.calcularValorMaoObra());
		sb.append("\r\n");
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.prazoEntrega);
		
		return sb.toString();
	}
	
	public abstract float calcularValorMaoObra() throws TamanhoFerragemZeradaException, PisoNuloException, NecessitaFundacaoProfundaException;
	
	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	
}
