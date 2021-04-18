package edu.ifma.lpweb.imobiliaria.repository;

import edu.ifma.lpweb.imobiliaria.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}