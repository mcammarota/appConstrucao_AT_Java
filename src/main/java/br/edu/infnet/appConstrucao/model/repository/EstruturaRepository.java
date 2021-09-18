package br.edu.infnet.appConstrucao.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appConstrucao.model.domain.Estrutura;

@Repository
public interface EstruturaRepository extends CrudRepository<Estrutura, Integer>{

	@Query("from Estrutura e where e.usuario.id = :userId")
	public List<Estrutura> obterLista(Integer userId);
}
