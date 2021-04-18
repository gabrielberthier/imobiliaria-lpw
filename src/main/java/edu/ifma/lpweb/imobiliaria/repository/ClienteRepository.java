package edu.ifma.lpweb.imobiliaria.repository;

import edu.ifma.lpweb.imobiliaria.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeClienteContaining(String nomeCliente );
    Page<Cliente> findByNomeClienteContaining(String nomeCliente, Pageable paginacao);

    @Query(value = "select c from clientes c where c.telefone1 = ?1")
    List<Cliente> buscaPorTelefone(String telefone);
}
