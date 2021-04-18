package edu.ifma.lpweb.imobiliaria.service;


import edu.ifma.lpweb.imobiliaria.model.Cliente;
import edu.ifma.lpweb.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscaPor(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscaPor(String nome) {
        return clienteRepository.findByNomeClienteContaining(nome);
    }

    public Page<Cliente> buscaPor(String nome, Pageable paginacao) {
        return clienteRepository.findByNomeClienteContaining(nome, paginacao);
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    @Transactional
    public void removePelo(Long id) {
        clienteRepository.deleteById(id);
    }

    public Page<Cliente> buscaCom(Pageable paginacao) {
        return clienteRepository.findAll(paginacao );
    }


}
