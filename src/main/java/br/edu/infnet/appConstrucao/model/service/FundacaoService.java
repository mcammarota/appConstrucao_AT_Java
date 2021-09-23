package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.AcabamentoRepository;
import br.edu.infnet.appConstrucao.model.repository.EstruturaRepository;
import br.edu.infnet.appConstrucao.model.repository.FundacaoRepository;

@Service
public class FundacaoService {

	@Autowired
	private FundacaoRepository fundacaoRepository;
	
	public List<Fundacao> obterLista(Usuario usuario){
		
		return (List<Fundacao>) fundacaoRepository.obterLista(usuario.getId());
	}
	
	public List<Fundacao> obterLista(){
		
		return (List<Fundacao>) fundacaoRepository.findAll();
	}
	
	public void incluir(Fundacao fundacao) {
		
		fundacaoRepository.save(fundacao);
	}
	
	public void excluir(int id) {
		
		fundacaoRepository.deleteById(id);
	}
	
	public Fundacao obterPorId(int id) {
		
		return fundacaoRepository.findById(id).orElse(null);
	}
	
	public int obterQtde() {
		return (int) fundacaoRepository.count();
	}
}
