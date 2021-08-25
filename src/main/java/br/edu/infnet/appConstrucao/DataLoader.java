package br.edu.infnet.appConstrucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.UsuarioService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNome("Marcos Cammarota");
		usuario.setEmail("marcos@cammarota.com");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		
		usuarioService.incluirUsuario(usuario);
	}

}
