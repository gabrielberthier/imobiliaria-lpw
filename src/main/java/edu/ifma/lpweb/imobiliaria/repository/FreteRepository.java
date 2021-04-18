package edu.ifma.lpweb.imobiliaria.repository;

import edu.ifma.lpweb.imobiliaria.model.Cliente;
import edu.ifma.lpweb.imobiliaria.model.Frete;
import edu.ifma.lpweb.imobiliaria.repository.frete.FreteRepositoryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>, FreteRepositoryQuery {

    List<Frete> findByDescricaoContaining(String descricao );
    Page<Frete> findByDescricaoContaining(String descricao, Pageable paginacao);

    List<Frete> findAllByCliente(Cliente cliente);

}
