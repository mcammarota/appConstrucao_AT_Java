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
import br.edu.infnet.appConstrucao.model.domain.Fundacao;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;
import br.edu.infnet.appConstrucao.model.service.EstruturaService;
import br.edu.infnet.appConstrucao.model.service.FundacaoService;

@Controller
public class FundacaoController {
	
	@Autowired
	private FundacaoService fundacaoService;
	
	@GetMapping(value = "/fundacao/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("fundacoes", fundacaoService.obterLista(usuario));
		
		return "fundacao/lista";
	}
	
	@GetMapping(value = "/fundacao")
	public String telaCadastro() {
		
		return "fundacao/cadastro";
	}

	@PostMapping(value = "/fundacao/incluir")
	public String incluir(Model model, Fundacao fundacao, @SessionAttribute("user") Usuario usuario) {
		
		fundacao.setUsuario(usuario);
		
		fundacaoService.incluir(fundacao);
		
		model.addAttribute("msg", "Fundação cadastrada com sucesso!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/fundacao/{id}/excluir")
	public String excluir(Model model, @PathVariable int id, @SessionAttribute("user") Usuario usuario) {
		
		Fundacao fundacao = fundacaoService.obterPorId(id);
		
		String mensagem = null;
		
		try {
			
			fundacaoService.excluir(id);
			
			mensagem = "Fundação removida com sucesso!";
			
		} catch (Exception e) {
			
			mensagem = "Não foi possível realizar a exclusão da fundação.";
			
		}
		
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}
