package br.edu.infnet.appConstrucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.service.AcabamentoService;

@Component
public class ProdutoLoader implements ApplicationRunner{

	@Autowired
	private AcabamentoService acabamentoService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Acabamento acab1 = new Acabamento("1º Acabamento", 1000, 15);
		acab1.setPiso("Porcelanato");
		acab1.setPintura("Acetinada");
		acab1.setRodape(true);
		
		acabamentoService.incluir(acab1);
		
		Acabamento acab2 = new Acabamento("2º Acabamento", 500, 10);
		acab2.setPiso("Cerâmica");
		acab2.setPintura("Acrílica");
		acab2.setRodape(false);
		
		acabamentoService.incluir(acab2);
		
		for(Acabamento a : acabamentoService.obterLista()) {
			System.out.println(a);
		}
		
		acabamentoService.excluir(1);

		for(Acabamento a : acabamentoService.obterLista()) {
			System.out.println(a);
		}
		
		Acabamento a3 = acabamentoService.obterPorId(2);
		
		System.out.println(a3.getDescricao());
	}

	
}
