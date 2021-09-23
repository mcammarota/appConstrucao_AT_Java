package br.edu.infnet.appConstrucao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Cotacao;
import br.edu.infnet.appConstrucao.model.domain.Empresa;
import br.edu.infnet.appConstrucao.model.domain.Estrutura;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;
import br.edu.infnet.appConstrucao.model.domain.Produto;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;
import br.edu.infnet.appConstrucao.model.service.CotacaoService;
import br.edu.infnet.appConstrucao.model.service.EstruturaService;
import br.edu.infnet.appConstrucao.model.service.FundacaoService;

@Component
@Order(4)
public class CotacaoLoader implements ApplicationRunner{

	@Autowired
	private CotacaoService cotacaoService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Empresa empresa = new Empresa();
		empresa.setId(1);
		
		Acabamento a1 = new Acabamento();
		a1.setId(1);
		
		Estrutura e1 = new Estrutura();
		e1.setId(2);
		
		Fundacao f1 = new Fundacao();
		f1.setId(3);
			
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(a1);
		produtos.add(e1);
		produtos.add(f1);
		
		Cotacao cotacao = new Cotacao();
		cotacao.setDescricao("Cotacao inicial");
		cotacao.setProdutos(produtos);
		cotacao.setEmpresa(empresa);
		cotacao.setUsuario(usuario);
		
		cotacaoService.incluir(cotacao);

	}

	
}
