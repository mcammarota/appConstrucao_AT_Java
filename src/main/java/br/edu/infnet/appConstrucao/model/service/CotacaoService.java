package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Cotacao;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.AcabamentoRepository;
import br.edu.infnet.appConstrucao.model.repository.CotacaoRepository;

@Service
public class CotacaoService {

	@Autowired
	private CotacaoRepository cotacaoRepository;
	
	public List<Cotacao> obterLista(Usuario usuario){
		
		return (List<Cotacao>) cotacaoRepository.obterLista(usuario.getId());
	}
	
	public List<Cotacao> obterLista(){
		
		return (List<Cotacao>) cotacaoRepository.findAll();
	}
	
	public void incluir(Cotacao cotacao) {
		
		cotacaoRepository.save(cotacao);
	}
	
	public void excluir(int id) {
		
		cotacaoRepository.deleteById(id);
	}
	
	public Cotacao obterPorId(int id) {
		
		return cotacaoRepository.findById(id).orElse(null);
	}
	
	public int obterQtde() {
		return (int) cotacaoRepository.count();
	}
}
