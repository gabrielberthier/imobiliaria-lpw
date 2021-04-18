package edu.ifma.lpweb.imobiliaria.service;

import edu.ifma.lpweb.imobiliaria.model.Cidade;
import edu.ifma.lpweb.imobiliaria.model.Frete;
import edu.ifma.lpweb.imobiliaria.repository.CidadeRepository;
import edu.ifma.lpweb.imobiliaria.repository.ClienteRepository;
import edu.ifma.lpweb.imobiliaria.repository.FreteRepository;
import edu.ifma.lpweb.imobiliaria.repository.filter.FreteFiltro;
import edu.ifma.lpweb.imobiliaria.service.exceptions.UnableToCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreteService {
    private final FreteRepository freteRepository;
    private CidadeRepository cidadeRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    @Transactional(readOnly = true)
    public Page<Frete> busca(FreteFiltro filtro, Pageable page) {
        return freteRepository.filtra(filtro, page );
    }



    public FreteService(FreteRepository freteRepository,
                        CidadeRepository cidadeRepository,
                        ClienteRepository clienteRepository) {
        this.freteRepository = freteRepository;
        this.cidadeRepository = cidadeRepository;
        this.clienteRepository = clienteRepository;
    }

    public void insertNewFreight(Frete frete) throws UnableToCreateException {
        var cidade = cidadeRepository.findById(frete.getCidade().getId());
        var cliente = clienteRepository.findById(frete.getCliente().getId());
        if(cidade.isEmpty() || cliente.isEmpty()){
            throw new UnableToCreateException("One or more necessary fields not set to instance");
        }
        freteRepository.save(frete);
    }

    public Cidade getCityWithMoreFreights(){
        return cidadeRepository.findCityWithMoreFreights();
    }
}
