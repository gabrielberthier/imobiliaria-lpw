package edu.ifma.lpweb.imobiliaria.model;
import edu.ifma.lpweb.imobiliaria.contracts.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "locacao")
public class Locacao implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_aluguel")
    private BigDecimal valorAluguel;
    @Column(name = "percentual_multa")
    private BigDecimal percentualMulta;
    @Column(name = "dia_vencimento")
    private int dia_vencimento;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    @Column(name = "data_fim")
    private LocalDate  dataFim;
    private boolean  ativo;
    private String  obs;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Imovel imovel;

    public List<Aluguel> getAluguels() {
        return aluguels.stream().collect(Collectors.toList());
    }

    public void setAluguels(List<Aluguel> aluguels) {
        this.aluguels = aluguels;
    }

    @OneToMany
    private List<Aluguel> aluguels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public BigDecimal getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(BigDecimal percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public int getDia_vencimento() {
        return dia_vencimento;
    }

    public void setDia_vencimento(int dia_vencimento) {
        this.dia_vencimento = dia_vencimento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }


}
