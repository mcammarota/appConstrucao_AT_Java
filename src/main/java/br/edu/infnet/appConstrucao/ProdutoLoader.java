package br.edu.infnet.appConstrucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;
import br.edu.infnet.appConstrucao.model.service.EstruturaService;
import br.edu.infnet.appConstrucao.model.service.FundacaoService;

@Component
@Order(3)
public class ProdutoLoader implements ApplicationRunner{

	@Autowired
	private AcabamentoService acabamentoService;
	@Autowired
	private EstruturaService estruturaService;
	@Autowired
	private FundacaoService fundacaoService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Acabamento a1 = new Acabamento("Acabamento da sala", 1000, 15);
		a1.setPiso("Porcelanato");
		a1.setPintura("Acetinada");
		a1.setRodape(true);
		a1.setUsuario(usuario);
			
		acabamentoService.incluir(a1);
		
		Estrutura e1 = new Estrutura("Estrutura do prédio", 10000, 30);
		e1.setCaracteristica("Concreto armado");
		e1.setTamanhoFerragem(12);
		e1.setMetalica(true);
		e1.setUsuario(usuario);
		
		estruturaService.incluir(e1);
		
		Fundacao f1 = new Fundacao("Fundacao do prédio", 8000, 25);
		f1.setFundacaoRasa(false);
		f1.setTipo("Estaca");
		f1.setProfundidade(10);
		f1.setUsuario(usuario);
		
		fundacaoService.incluir(f1);
	}

	
}
