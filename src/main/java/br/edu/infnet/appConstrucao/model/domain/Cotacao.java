package br.edu.infnet.appConstrucao.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cotacao {

	private String descricao;
	private LocalDateTime data;
	private Empresa empresa;
	
	public Cotacao() {
		data = LocalDateTime.now();
	}

	public Cotacao(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s;%s;%s;", 
				this.descricao, 
				this.data.format(formato),
				this.empresa
				);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
