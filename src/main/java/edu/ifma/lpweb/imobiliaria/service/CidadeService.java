package edu.ifma.lpweb.imobiliaria.service;


import edu.ifma.lpweb.imobiliaria.model.Cidade;
import edu.ifma.lpweb.imobiliaria.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> todos() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> buscaPor(Long id) {
        return cidadeRepository.findById(id);
    }

    public List<Cidade> buscaPor(String nome) {
        return cidadeRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Cidade salva(Cidade cliente) {
        return cidadeRepository.save(cliente);
    }

    @Transactional
    public void removePelo(Long id) {
        cidadeRepository.deleteById(id);
    }

}
