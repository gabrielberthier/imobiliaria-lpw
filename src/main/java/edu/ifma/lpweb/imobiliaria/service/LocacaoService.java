package edu.ifma.lpweb.imobiliaria.service;

import edu.ifma.lpweb.imobiliaria.model.Locacao;
import edu.ifma.lpweb.imobiliaria.repository.LocacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository){
        this.locacaoRepository = locacaoRepository;
    }

    @Transactional
    public Locacao salva(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public Optional<Locacao> buscaPor(Long id) {
        return locacaoRepository.findById(id);
    }

    public void removeBy(Long id) {
        locacaoRepository.deleteById(id);
    }

    public Page<Locacao> buscaCom(Pageable paginacao) {
        return locacaoRepository.findAll(paginacao);
    }

}
