package br.edu.infnet.appConstrucao.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;
import br.edu.infnet.appConstrucao.model.domain.Cotacao;
import br.edu.infnet.appConstrucao.model.domain.Fundacao;

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, Integer>{

	@Query("from Cotacao c where c.usuario.id = :userId")
	public List<Cotacao> obterLista(Integer userId);
}
