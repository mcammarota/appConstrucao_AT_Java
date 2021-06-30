package br.edu.infnet.appConstrucao.model.domain;

import br.edu.infnet.appConstrucao.model.exceptions.PisoNuloException;

public class Acabamento extends Produto {
	
	private String piso;
	private String pintura;
	private boolean rodape;

	public Acabamento(String descricao, float valor, int prazoEntrega) {
		super(descricao, valor, prazoEntrega);
	}
		
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.piso);
		sb.append(";");
		sb.append(this.pintura);
		sb.append(";");
		sb.append(this.rodape ? "S" : "N");

		return sb.toString();
	}

	@Override
	public float calcularValorMaoObra() throws PisoNuloException {
		
		if(this.piso == null) {
			throw new PisoNuloException("O piso não pode ser nulo!");
		}
		
		float ValorMaoObraPisoPorDia = 0;
		if("porcelanato".equalsIgnoreCase(piso)) {
			ValorMaoObraPisoPorDia = 100;
		}

		return this.getPrazoEntrega() * ValorMaoObraPisoPorDia;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPintura() {
		return pintura;
	}

	public void setPintura(String pintura) {
		this.pintura = pintura;
	}

	public boolean isRodape() {
		return rodape;
	}

	public void setRodape(boolean rodape) {
		this.rodape = rodape;
	}

}
