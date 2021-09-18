package br.edu.infnet.appConstrucao.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;

@Repository
public interface FundacaoRepository extends CrudRepository<Fundacao, Integer>{

	@Query("from Fundacao f where f.usuario.id = :userId")
	public List<Fundacao> obterLista(Integer userId);
}
