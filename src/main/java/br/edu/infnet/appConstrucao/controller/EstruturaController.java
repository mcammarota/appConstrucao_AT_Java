package br.edu.infnet.appConstrucao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;
import br.edu.infnet.appConstrucao.model.service.EstruturaService;

@Controller
public class EstruturaController {
	
	@Autowired
	private EstruturaService estruturaService;
	
	@GetMapping(value = "/estrutura/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("estruturas", estruturaService.obterLista(usuario));
		
		return "estrutura/lista";
	}
	
	@GetMapping(value = "/estrutura")
	public String telaCadastro() {
		
		return "estrutura/cadastro";
	}

	@PostMapping(value = "/estrutura/incluir")
	public String incluir(Model model, Estrutura estrutura, @SessionAttribute("user") Usuario usuario) {
		
		estrutura.setUsuario(usuario);
		
		estruturaService.incluir(estrutura);
		
		model.addAttribute("msg", "Estrutura cadastrada com sucesso!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/estrutura/{id}/excluir")
	public String excluir(Model model, @PathVariable int id, @SessionAttribute("user") Usuario usuario) {
		
		Estrutura estrutura = estruturaService.obterPorId(id);
		
		String mensagem = null;
		
		try {
			
			estruturaService.excluir(id);
			
			mensagem = "Estrutura removida com sucesso!";
			
		} catch (Exception e) {
			
			mensagem = "Não foi possível realizar a exclusão da estrutura.";
			
		}
		
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}
