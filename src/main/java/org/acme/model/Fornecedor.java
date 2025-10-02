package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "fornecedor", uniqueConstraints = {
        @UniqueConstraint(name = "uk_fornecedor_cnpj", columnNames = "cnpj")
})
public class Fornecedor extends DefaultEntity {

    @NotBlank
    @Column(nullable = false, length = 160)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 18)
    private String cnpj;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String telefone;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
