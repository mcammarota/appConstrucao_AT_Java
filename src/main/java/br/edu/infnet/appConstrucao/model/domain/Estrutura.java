package br.edu.infnet.appConstrucao.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appConstrucao.model.exceptions.TamanhoFerragemZeradaOuNegativaException;

@Entity
public class Estrutura extends Produto {

	private String caracteristica;
	private float tamanhoFerragem;
	private boolean metalica;
	
	public Estrutura() {

	}
	
	public Estrutura(String descricao, float valor, int prazoEntrega) {
		super(descricao, valor, prazoEntrega);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.caracteristica);
		sb.append(";");
		sb.append(this.tamanhoFerragem);
		sb.append(";");
		sb.append(this.metalica ? "S" : "N");
		
		return sb.toString();
	}
	
	@Override
	public float calcularValorMaoObra() throws TamanhoFerragemZeradaOuNegativaException {
		
		float ValorMaoObraMetalicaPorDia = 0;
		
		if(this.tamanhoFerragem <= 0) {
			throw new TamanhoFerragemZeradaOuNegativaException("O tamanho da ferragem não pode ser menor ou igual a 0!");
		}
		
		if(tamanhoFerragem > 20) {
			ValorMaoObraMetalicaPorDia = 200;
		} else {
			ValorMaoObraMetalicaPorDia = 150;
		}
		
		return this.getPrazoEntrega() * ValorMaoObraMetalicaPorDia;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public float getTamanhoFerragem() {
		return tamanhoFerragem;
	}

	public void setTamanhoFerragem(float tamanho_ferragem) {
		this.tamanhoFerragem = tamanho_ferragem;
	}

	public boolean isMetalica() {
		return metalica;
	}

	public void setMetalica(boolean metalica) {
		this.metalica = metalica;
	}

}
