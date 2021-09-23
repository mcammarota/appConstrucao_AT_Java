package br.edu.infnet.appConstrucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appConstrucao.model.domain.Empresa;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.EmpresaService;
import br.edu.infnet.appConstrucao.model.service.UsuarioService;

@Component
@Order(2)
public class EmpresaLoader implements ApplicationRunner {

	@Autowired
	private EmpresaService empresaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Empresa empresa = new Empresa();
		empresa.setNome("Infnet");
		empresa.setEmail("infnet@infnet.com.br");
		empresa.setTelefone("33332222");
		empresa.setUsuario(usuario);
		
		empresaService.incluir(empresa);
	}

}
