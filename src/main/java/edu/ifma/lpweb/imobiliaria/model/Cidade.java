package edu.ifma.lpweb.imobiliaria.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Um nome necessita ser inserido para encontrar a cidade")
    private String nome;
    @NotBlank(message = "Uma UF necessita ser inserida")
    private String uf;
    @DecimalMin(value = "0.0")
    private BigDecimal taxa;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Frete> fretes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public List<Frete> getFretes() {
        var clone = fretes.stream().collect(Collectors.toList());
        return clone;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", taxa=" + taxa +
                ", fretes=" + fretes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id) &&
                nome.equals(cidade.nome) &&
                uf.equals(cidade.uf) &&
                taxa.equals(cidade.taxa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, uf, taxa);
    }
}
