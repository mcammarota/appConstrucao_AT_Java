package br.edu.infnet.appConstrucao.model.domain;

import br.edu.infnet.appConstrucao.model.exceptions.NecessitaFundacaoProfundaException;

public class Fundacao extends Produto {

	private boolean fundacaoRasa;
	private String tipo;
	private float profundidade;
	
	public Fundacao(String descricao, float valor, int prazoEntrega) {
		super(descricao, valor, prazoEntrega);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.fundacaoRasa ? "S" : "N");
		sb.append(";");
		sb.append(this.tipo);
		sb.append(";");
		sb.append(this.profundidade);
		
		return sb.toString();
	}

	@Override
	public float calcularValorMaoObra() throws NecessitaFundacaoProfundaException {
		
		if(this.fundacaoRasa == true && this.profundidade > 3) {
			throw new NecessitaFundacaoProfundaException("Não pode ter fundação rasa com mais de 3 metros!");
		}
		
		float ValorMaoObraTipoFundPorDia = 0;
		
		if("radier".equalsIgnoreCase(tipo)) {
			ValorMaoObraTipoFundPorDia = 50;
		}
		
		return this.getPrazoEntrega() * ValorMaoObraTipoFundPorDia;		
	}

	public boolean isFundacaoRasa() {
		return fundacaoRasa;
	}

	public void setFundacaoRasa(boolean fundacaoRasa) {
		this.fundacaoRasa = fundacaoRasa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}

}
