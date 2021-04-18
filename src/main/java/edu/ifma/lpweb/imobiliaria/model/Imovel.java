package edu.ifma.lpweb.imobiliaria.model;

import edu.ifma.lpweb.imobiliaria.contracts.Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "imoveis")
public class Imovel implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_imovel")
    private String tipoImovel;
    private String  endereco;
    private  String bairro;
    private int cep;
    private BigDecimal metragem;
    private int  dormitorios;
    private int  banheiros;
    private int  suites;
    @Column(name = "vagas_garagem")
    private int vagasGaragem;
    @Column(name = "valor_aluguel_sugerido")
    private     BigDecimal valorAluguelSugerido;
    private String  obs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipo_imovel) {
        this.tipoImovel = tipo_imovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public BigDecimal getMetragem() {
        return metragem;
    }

    public void setMetragem(BigDecimal metragem) {
        this.metragem = metragem;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        this.dormitorios = dormitorios;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagas_garagem) {
        this.vagasGaragem = vagas_garagem;
    }

    public BigDecimal getValorAluguelSugerido() {
        return valorAluguelSugerido;
    }

    public void setValorAluguelSugerido(BigDecimal valor_aluguel_sugerido) {
        this.valorAluguelSugerido = valor_aluguel_sugerido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }



}
