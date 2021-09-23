package br.edu.infnet.appConstrucao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario validar(String email, String senha) {
		
		return usuarioRepository.autenticacao(email, senha);
	}
	
	public void incluirUsuario(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> obterLista(){
		
		return (List<Usuario>)usuarioRepository.findAll();
	}
	
	public void excluir(Integer id) {
		
		usuarioRepository.deleteById(id);
	}
	
	public int obterQtde() {
		return (int) usuarioRepository.count();
	}
}
