package edu.ifma.lpweb.imobiliaria.service;

import edu.ifma.lpweb.imobiliaria.model.Imovel;
import edu.ifma.lpweb.imobiliaria.model.Locacao;
import edu.ifma.lpweb.imobiliaria.repository.ImovelRepository;
import edu.ifma.lpweb.imobiliaria.repository.LocacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository){
        this.imovelRepository = imovelRepository;
    }

    @Transactional
    public Imovel salva(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public Optional<Imovel> buscaPor(Long id) {
        return imovelRepository.findById(id);
    }

    public void removeBy(Long id) {
        imovelRepository.deleteById(id);
    }

    public Page<Imovel> buscaCom(Pageable paginacao) {
        return imovelRepository.findAll(paginacao);
    }
}
