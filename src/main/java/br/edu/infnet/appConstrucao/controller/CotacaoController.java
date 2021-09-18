package br.edu.infnet.appConstrucao.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Cotacao;
import br.edu.infnet.appConstrucao.model.domain.Produto;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;
import br.edu.infnet.appConstrucao.model.service.CotacaoService;
import br.edu.infnet.appConstrucao.model.service.EmpresaService;
import br.edu.infnet.appConstrucao.model.service.ProdutoService;

@Controller
public class CotacaoController {
	
	@Autowired
	private CotacaoService cotacaoService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/cotacao/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", cotacaoService.obterLista(usuario));
		
		return "cotacao/lista";
	}
	
	@GetMapping(value = "/cotacao")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("empresas", empresaService.obterLista(usuario));
		
		model.addAttribute("produtos", produtoService.obterLista(usuario));
		
		return "cotacao/cadastro";
	}

	@PostMapping(value = "/cotacao/incluir")
	public String incluir(Model model, Cotacao cotacao, @RequestParam String[] produtosId, @SessionAttribute("user") Usuario usuario) {
		
		List<Produto> produtos = new ArrayList<Produto>(); 
		
		for(String id : produtosId) {
			produtos.add(produtoService.obterPorId(Integer.valueOf(id)));
		}
		
		cotacao.setProdutos(produtos);
		
		cotacao.setUsuario(usuario);
		
		cotacaoService.incluir(cotacao);
		
		model.addAttribute("msg", "Cotação cadastrada com sucesso!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/cotacao/{id}/excluir")
	public String excluir(Model model, @PathVariable int id, @SessionAttribute("user") Usuario usuario) {
		
		Cotacao cotacao = cotacaoService.obterPorId(id);
		
		cotacaoService.excluir(id);
		
		model.addAttribute("msg", "Cotação removida com sucesso!");
		
		return telaLista(model, usuario);
	}
}
