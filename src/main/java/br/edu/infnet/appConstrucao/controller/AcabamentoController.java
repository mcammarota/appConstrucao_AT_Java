package br.edu.infnet.appConstrucao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;

@Controller
public class AcabamentoController {
	
	@Autowired
	private AcabamentoService acabamentoService;
	
	@GetMapping(value = "/acabamento/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("acabamentos", acabamentoService.obterLista(usuario));
		
		return "acabamento/lista";
	}
	
	@GetMapping(value = "/acabamento")
	public String telaCadastro() {
		
		return "acabamento/cadastro";
	}

	@PostMapping(value = "/acabamento/incluir")
	public String incluir(Model model, Acabamento acabamento, @SessionAttribute("user") Usuario usuario) {
		
		acabamento.setUsuario(usuario);
		
		acabamentoService.incluir(acabamento);
		
		model.addAttribute("msg", "Acabamento cadastrado com sucesso!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/acabamento/{id}/excluir")
	public String excluir(Model model, @PathVariable int id, @SessionAttribute("user") Usuario usuario) {
		
		Acabamento acab = acabamentoService.obterPorId(id);
		
		acabamentoService.excluir(id);
		
		model.addAttribute("msg", "Acabamento removido com sucesso!");
		
		return telaLista(model, usuario);
	}
}
