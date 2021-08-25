package br.edu.infnet.appConstrucao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "cadastro";
	}
	
	@PostMapping(value = "/usuario")
	public String incluirUsuario(Usuario usuario) {

		usuarioService.incluirUsuario(usuario);
		
		return "redirect:/";
	}
}
