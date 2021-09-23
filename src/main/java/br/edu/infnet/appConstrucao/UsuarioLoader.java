package br.edu.infnet.appConstrucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appConstrucao.model.domain.Endereco;
import br.edu.infnet.appConstrucao.model.domain.Usuario;
import br.edu.infnet.appConstrucao.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Endereco endereco = new Endereco();
		endereco.setBairro("Teste");
		endereco.setCep("12345678");
		endereco.setComplemento("compl teste");
		endereco.setLocalidade("local teste");
		endereco.setLogradouro("logr teste");
		endereco.setUf("RJ");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Marcos Cammarota");
		usuario.setEmail("marcos@cammarota.com");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		usuario.setEndereco(endereco);
		
		usuarioService.incluirUsuario(usuario);
	}

}
