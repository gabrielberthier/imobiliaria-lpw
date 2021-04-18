package edu.ifma.lpweb.imobiliaria.model;
import edu.ifma.lpweb.imobiliaria.contracts.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity(name = "clientes")
public class Cliente implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "nome_cliente")
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nomeCliente;
    private long cpf;
    @NotEmpty(message = "O telefone não pode ser nulo")
    private String telefone1;
    private String email;
    private LocalDate nascimento;
    @NotBlank
    private String endereco;

    public List<Frete> getFretes() {
        return fretes;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }

    @OneToMany
    private List<Frete> fretes;

    public List<Locacao> getLocacaoList() {
        List<Locacao> clone = locacaoList.stream().collect(Collectors.toList());
        return clone;
    }



    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }

    @OneToMany
    private List<Locacao> locacaoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", cpf=" + cpf +
                ", telefone1=" + telefone1 +
                ", email='" + email + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf == cliente.cpf &&
                telefone1 == cliente.telefone1 &&
                id.equals(cliente.id) &&
                nomeCliente.equals(cliente.nomeCliente) &&
                Objects.equals(email, cliente.email) &&
                nascimento.equals(cliente.nascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCliente, cpf, telefone1);
    }
}
