package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.AcabamentoRepository;
import br.edu.infnet.appConstrucao.model.repository.EstruturaRepository;

@Service
public class EstruturaService {

	@Autowired
	private EstruturaRepository estruturaRepository;
	
	public List<Estrutura> obterLista(Usuario usuario){
		
		return (List<Estrutura>) estruturaRepository.obterLista(usuario.getId());
	}
	
	public List<Estrutura> obterLista(){
		
		return (List<Estrutura>) estruturaRepository.findAll();
	}
	
	public void incluir(Estrutura estrutura) {
		
		estruturaRepository.save(estrutura);
	}
	
	public void excluir(int id) {
		
		estruturaRepository.deleteById(id);
	}
	
	public Estrutura obterPorId(int id) {
		
		return estruturaRepository.findById(id).orElse(null);
	}
	
	public int obterQtde() {
		return (int) estruturaRepository.count();
	}
}
