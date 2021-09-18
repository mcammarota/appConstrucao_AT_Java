package br.edu.infnet.appConstrucao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appConstrucao.model.domain.Empresa;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.EmpresaService;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(value = "/empresa")
	public String tela() {
		
		return "empresa/cadastro";
	}
	
	@GetMapping(value = "/empresa/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", empresaService.obterLista(usuario));
		
		return "empresa/lista";
	}

	@PostMapping(value = "/empresa/incluir")
	public String incluir(Model model, Empresa empresa, @SessionAttribute("user") Usuario usuario) {
		
		empresa.setUsuario(usuario);
		
		empresaService.incluir(empresa);
		
		String mensagem = "A empresa " + empresa.getNome() + " foi cadastrada com sucesso!";
		
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/empresa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		empresaService.excluir(id);

		return "redirect:/empresa/lista";
	}
}
