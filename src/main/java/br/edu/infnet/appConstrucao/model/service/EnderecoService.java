package br.edu.infnet.appConstrucao.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appConstrucao.clients.IEnderecoClient;
import br.edu.infnet.appConstrucao.model.domain.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Endereco obterCep(String cep) {
		
		return enderecoClient.obterCep(cep);
	}
}
