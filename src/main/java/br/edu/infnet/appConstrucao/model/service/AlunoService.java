package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Aluno;
import br.edu.infnet.appConstrucao.model.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository = null;
	
	public List<Aluno> obterLista(){
		
		return (List<Aluno>) alunoRepository.findAll();
	}
	
	public void incluir(Aluno aluno) {
		
		alunoRepository.save(aluno);		
	}
	
	public void excluir(Integer id) {
		
		alunoRepository.deleteById(id);
	}
}
