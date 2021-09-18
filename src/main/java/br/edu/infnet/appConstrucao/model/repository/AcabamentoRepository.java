package br.edu.infnet.appConstrucao.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appConstrucao.model.domain.Acabamento;

@Repository
public interface AcabamentoRepository extends CrudRepository<Acabamento, Integer>{

	@Query("from Acabamento a where a.usuario.id = :userId")
	public List<Acabamento> obterLista(Integer userId);
}
