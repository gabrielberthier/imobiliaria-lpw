package edu.ifma.lpweb.imobiliaria.controller;

import edu.ifma.lpweb.imobiliaria.model.Aluguel;
import edu.ifma.lpweb.imobiliaria.service.AluguelService;
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
@RequestMapping("/aluguel")
public class AluguelController {
    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @PostMapping
    public ResponseEntity<Aluguel> cadastro(@RequestBody @Valid Aluguel aluguel,
                                            UriComponentsBuilder builder) {
        final Aluguel savedInstance = aluguelService.salva(aluguel);
        final URI uri = builder
                .path("/aluguel/{id}")
                .buildAndExpand(savedInstance.getId()).toUri();

        return ResponseEntity.created(uri).body(savedInstance );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> atualiza(@PathVariable Long id,
                                            @RequestBody @Valid Aluguel locacao) {
        Optional<Aluguel> optional = aluguelService.buscaPor(id);

        if (optional.isPresent()) {
            locacao.setId(id);
            var aluguelAtualizado = aluguelService.salva(locacao);
            return ResponseEntity.ok(aluguelAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Aluguel> optional = aluguelService.buscaPor(id );
        if (optional.isPresent()) {
            aluguelService.removeBy(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscaPor(@PathVariable Long id) {
        Optional<Aluguel> optional = aluguelService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public Page<Aluguel> lista(@RequestParam(required = false) String nome,
                               @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5)
                                       Pageable paginacao) {
        return aluguelService.buscaCom(paginacao );
    }
}
