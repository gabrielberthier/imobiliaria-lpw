package edu.ifma.lpweb.imobiliaria.service;

import edu.ifma.lpweb.imobiliaria.model.Aluguel;
import edu.ifma.lpweb.imobiliaria.model.Locacao;
import edu.ifma.lpweb.imobiliaria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;
    public List<Aluguel> list() {
        return aluguelRepository.findAll();
    }

    public Aluguel salva(Aluguel aluguel) {
        return this.aluguelRepository.save(aluguel);
    }

    public Optional<Aluguel> buscaPor(Long id) {
        return  aluguelRepository.findById(id);
    }

    public void removeBy(Long id) {
        aluguelRepository.deleteById(id);
    }

    public Page<Aluguel> buscaCom(Pageable paginacao) {
        return aluguelRepository.findAll(paginacao);
    }
}