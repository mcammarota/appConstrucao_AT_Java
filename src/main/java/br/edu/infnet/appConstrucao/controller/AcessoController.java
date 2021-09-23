package br.edu.infnet.appConstrucao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;
import br.edu.infnet.appConstrucao.model.service.CotacaoService;
import br.edu.infnet.appConstrucao.model.service.EmpresaService;
import br.edu.infnet.appConstrucao.model.service.EstruturaService;
import br.edu.infnet.appConstrucao.model.service.FundacaoService;
import br.edu.infnet.appConstrucao.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private AcabamentoService acabamentoService;
	@Autowired
	private EstruturaService estruturaService;
	@Autowired
	private FundacaoService fundacaoService;
	@Autowired
	private CotacaoService cotacaoService;
	
	@GetMapping(value = "/app")
	public String telaApp(Model model) {

		Map<String, Integer> mapaTotal = new HashMap<String, Integer>();
		mapaTotal.put("Usuários", usuarioService.obterQtde());
		mapaTotal.put("Empresas", empresaService.obterQtde());
		mapaTotal.put("Acabamentos", acabamentoService.obterQtde());
		mapaTotal.put("Estruturas", estruturaService.obterQtde());
		mapaTotal.put("Fundações", fundacaoService.obterQtde());
		mapaTotal.put("Cotações", cotacaoService.obterQtde());

		model.addAttribute("total", mapaTotal);
		
		return "app";
	}

	@GetMapping(value = "/")
	public String telaHome() {
		
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {

		Usuario usuario = usuarioService.validar(email, senha);
		
		if(usuario != null) {
			
			model.addAttribute("user", usuario);
			
			return "index";
		} else {

			model.addAttribute("mensagem", "Autenticação inválida para o usuário " + email);
			
			return "login";
		}

	}
}
