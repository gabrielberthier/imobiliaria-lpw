package edu.ifma.lpweb.imobiliaria.repository;

import edu.ifma.lpweb.imobiliaria.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}