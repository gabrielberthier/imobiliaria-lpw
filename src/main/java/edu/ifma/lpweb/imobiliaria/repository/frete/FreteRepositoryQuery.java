package edu.ifma.lpweb.imobiliaria.repository.frete;

import edu.ifma.lpweb.imobiliaria.model.Frete;
import edu.ifma.lpweb.imobiliaria.repository.filter.FreteFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FreteRepositoryQuery {
    Page<Frete> filtra(FreteFiltro freteFiltro, Pageable pageable );
}
