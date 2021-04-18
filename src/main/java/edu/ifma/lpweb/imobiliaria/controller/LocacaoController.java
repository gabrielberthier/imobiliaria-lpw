package edu.ifma.lpweb.imobiliaria.controller;

import edu.ifma.lpweb.imobiliaria.model.Cliente;
import edu.ifma.lpweb.imobiliaria.model.Locacao;
import edu.ifma.lpweb.imobiliaria.service.LocacaoService;
import org.hibernate.id.uuid.LocalObjectUuidHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
    private final LocacaoService locacaoService;

    @Autowired
    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<Locacao> cadastro(@RequestBody @Valid Locacao locacao,
                                            UriComponentsBuilder builder) {
        final Locacao savedInstance = locacaoService.salva(locacao);
        final URI uri = builder
                .path("/locacao/{id}")
                .buildAndExpand(savedInstance.getId()).toUri();

        return ResponseEntity.created(uri).body(savedInstance );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locacao> atualiza(@PathVariable Long id,
                                            @RequestBody @Valid Locacao locacao) {
        Optional<Locacao> optional = locacaoService.buscaPor(id);

        if (optional.isPresent()) {
            locacao.setId(id);
            var clienteAtualizado = locacaoService.salva(locacao);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Locacao> optional = locacaoService.buscaPor(id );
        if (optional.isPresent()) {
            locacaoService.removeBy(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> buscaPor(@PathVariable Long id) {
        Optional<Locacao> optional = locacaoService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Page<Locacao> lista(@RequestParam(required = false) String nome,
                               @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5)
                                       Pageable paginacao) {
        return locacaoService.buscaCom(paginacao );
    }
}
