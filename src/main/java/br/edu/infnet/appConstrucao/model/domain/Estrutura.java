package br.edu.infnet.appConstrucao.model.domain;

import br.edu.infnet.appConstrucao.model.exceptions.TamanhoFerragemZeradaOuNegativaException;

public class Estrutura extends Produto {

	private String descricao;
	private float tamanho_ferragem;
	private boolean metalica;
	
	public Estrutura(String descricao, float valor, int prazoEntrega) {
		super(descricao, valor, prazoEntrega);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.tamanho_ferragem);
		sb.append(";");
		sb.append(this.metalica ? "S" : "N");
		
		return sb.toString();
	}
	
	@Override
	public float calcularValorMaoObra() throws TamanhoFerragemZeradaOuNegativaException {
		
		float ValorMaoObraMetalicaPorDia = 0;
		
		if(this.tamanho_ferragem <= 0) {
			throw new TamanhoFerragemZeradaOuNegativaException("O tamanho da ferragem não pode ser menor ou igual a 0!");
		}
		
		if(tamanho_ferragem > 20) {
			ValorMaoObraMetalicaPorDia = 200;
		} else {
			ValorMaoObraMetalicaPorDia = 150;
		}
		
		return this.getPrazoEntrega() * ValorMaoObraMetalicaPorDia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getTamanho_ferragem() {
		return tamanho_ferragem;
	}

	public void setTamanho_ferragem(float tamanho_ferragem) {
		this.tamanho_ferragem = tamanho_ferragem;
	}

	public boolean isMetalica() {
		return metalica;
	}

	public void setMetalica(boolean metalica) {
		this.metalica = metalica;
	}

}
