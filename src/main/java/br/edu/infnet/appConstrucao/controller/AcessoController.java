package br.edu.infnet.appConstrucao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appConstrucao.model.domain.Aluno;


@Controller
public class AcessoController {

	@GetMapping(value = "/")
	public String telaLogin() {
		
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Aluno aluno = null;
		if(email.equals(senha)) {
			
			aluno = new Aluno("Marcos Cammarota", email);
		}
		
		if(aluno != null) {
			
			return "index";
		} else {

			//request.setAttribute("mensagem", "Autenticação inválida para o usuário " + email +"!");
			model.addAttribute("mensagem", "Autenticação inválida para o usuário " + email);
			return "login";
		}

	}
}