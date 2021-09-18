package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Produto;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.AcabamentoRepository;
import br.edu.infnet.appConstrucao.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> obterLista(Usuario usuario){
		
		return (List<Produto>) produtoRepository.obterLista(usuario.getId());
	}
	
	public List<Produto> obterLista(){
		
		return (List<Produto>) produtoRepository.findAll();
	}
	
	public void excluir(int id) {
		
		produtoRepository.deleteById(id);
	}
	
	public Produto obterPorId(int id) {
		
		return produtoRepository.findById(id).orElse(null);
	}
}
