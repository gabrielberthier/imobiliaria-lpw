package edu.ifma.lpweb.imobiliaria.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "fretes")
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    @NotEmpty(message = "A descrição não pode ser vazia")
    private String descricao;
    @Column(name="valor")
    @DecimalMin(value = "0.0")
    private BigDecimal valor;

    @Positive(message = "O peso deve ser informado")
    private double peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frete frete = (Frete) o;
        return Double.compare(frete.peso, peso) == 0 &&
                Objects.equals(id, frete.id) &&
                descricao.equals(frete.descricao) &&
                valor.equals(frete.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, peso);
    }
}
