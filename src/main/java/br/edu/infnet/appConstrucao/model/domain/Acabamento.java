package br.edu.infnet.appConstrucao.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appConstrucao.model.exceptions.PisoNuloException;

@Entity
public class Acabamento extends Produto {
	
	private String piso;
	private String pintura;
	private boolean rodape;
	
	public Acabamento() {
		
	}

	public Acabamento(String descricao, float valor, int prazoEntrega) {
		super(descricao, valor, prazoEntrega);
	}
		
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append("Piso: ");
		sb.append(this.piso);
		sb.append(";");
		sb.append("Pintura: ");
		sb.append(this.pintura);
		sb.append(";");
		sb.append("Rodapé: ");
		sb.append(this.rodape ? "S" : "N");

		return sb.toString();
	}

	@Override
	public float calcularValorMaoObra() throws PisoNuloException {
		
		if(this.piso.isBlank() | this.piso.isEmpty()) {
			throw new PisoNuloException("O piso não pode ser nulo!");
		}
		
		float ValorMaoObraPisoPorDia = 0;
		if("porcelanato".equalsIgnoreCase(piso)) {
			ValorMaoObraPisoPorDia = 100;
		} else if("cerâmica".equalsIgnoreCase(piso)){
			ValorMaoObraPisoPorDia = 80;
		} else {
			ValorMaoObraPisoPorDia = 60;
		}
		
		float ValorMaoObraPinturaPorDia = 0;
		if("acetinada".equalsIgnoreCase(pintura)) {
			ValorMaoObraPinturaPorDia = 40;
		}
		else {
			ValorMaoObraPinturaPorDia = 30;
		}

		return this.getPrazoEntrega() * (ValorMaoObraPisoPorDia + ValorMaoObraPinturaPorDia);
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
