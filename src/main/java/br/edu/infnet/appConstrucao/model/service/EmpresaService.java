package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Empresa;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository = null;
	
	public List<Empresa> obterLista(Usuario usuario){
		
		return empresaRepository.obterLista(usuario.getId());
	}
	
	public List<Empresa> obterLista(){
		
		return (List<Empresa>) empresaRepository.findAll();
	}
	
	public void incluir(Empresa empresa) {
		
		empresaRepository.save(empresa);		
	}
	
	public void excluir(Integer id) {
		
		empresaRepository.deleteById(id);
	}
	
	public Empresa obterPorId(Integer id) {
		
		return empresaRepository.findById(id).orElse(null);
	}
	
	public int obterQtde() {
		return (int) empresaRepository.count();
	}
}
