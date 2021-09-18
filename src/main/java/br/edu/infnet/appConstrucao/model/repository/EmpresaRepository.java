package br.edu.infnet.appConstrucao.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appConstrucao.model.domain.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{

	@Query("from Empresa e where e.usuario.id = :userId")
	public List<Empresa> obterLista(Integer userId);
}
