package edu.ifma.lpweb.imobiliaria.model;

import edu.ifma.lpweb.imobiliaria.contracts.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "alugueis")
public class Aluguel implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="data_vencimento")
    private LocalDate dataDeVencimento;
    @Column(name="valor_pago")
    private BigDecimal valorPago;
    @Column(name="data_pagamento")
    private LocalDate dataPagamento;
    private String obs;
    @ManyToOne
    private Locacao locacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }


    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valor_pago) {
        this.valorPago = valor_pago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate data_pagamento) {
        this.dataPagamento = data_pagamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }


}
