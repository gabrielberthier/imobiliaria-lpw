package edu.ifma.lpweb.imobiliaria.repository;

import edu.ifma.lpweb.imobiliaria.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByNomeContaining(String nome );
    @Query(value = "select c from cidades c where c.nome = ?1")
    List<Cidade> buscaPor(String nome);
    @Query(value = "select c, COUNT(fretes) from cidades c order by c.id DESC ")
    Cidade findCityWithMoreFreights();
}
