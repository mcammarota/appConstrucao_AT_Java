package br.edu.infnet.appConstrucao.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.appConstrucao.model.exceptions.NecessitaFundacaoProfundaException;
import br.edu.infnet.appConstrucao.model.exceptions.PisoNuloException;
import br.edu.infnet.appConstrucao.model.exceptions.TamanhoFerragemZeradaOuNegativaException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private float valor;
	private int prazoEntrega;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "produtos")
	private List<Cotacao> cotacoes;
	
	public Produto() {
		
	}
	
	public Produto(String descricao, float valor, int prazoEntrega) {
		this.descricao = descricao;
		this.valor = valor;
		this.prazoEntrega = prazoEntrega;
	}
	
	public String obterProduto() throws PisoNuloException, TamanhoFerragemZeradaOuNegativaException, NecessitaFundacaoProfundaException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append("Valor mão de obra: ");
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
	
	public abstract float calcularValorMaoObra() throws PisoNuloException, TamanhoFerragemZeradaOuNegativaException, NecessitaFundacaoProfundaException;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}
	
}
