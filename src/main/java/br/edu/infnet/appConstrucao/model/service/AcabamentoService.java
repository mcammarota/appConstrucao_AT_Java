package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.AcabamentoRepository;

@Service
public class AcabamentoService {

	@Autowired
	private AcabamentoRepository acabamentoRepository;
	
	public List<Acabamento> obterLista(Usuario usuario){
		
		return (List<Acabamento>) acabamentoRepository.obterLista(usuario.getId());
	}
	
	public List<Acabamento> obterLista(){
		
		return (List<Acabamento>) acabamentoRepository.findAll();
	}
	
	public void incluir(Acabamento acabamento) {
		
		acabamentoRepository.save(acabamento);
	}
	
	public void excluir(int id) {
		
		acabamentoRepository.deleteById(id);
	}
	
	public Acabamento obterPorId(int id) {
		
		return acabamentoRepository.findById(id).orElse(null);
	}
	
	public int obterQtde() {
		return (int) acabamentoRepository.count();
	}
}
