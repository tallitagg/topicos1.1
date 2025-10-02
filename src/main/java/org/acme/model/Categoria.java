package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "categoria", uniqueConstraints = {
        @UniqueConstraint(name = "uk_categoria_nome", columnNames = "nome")
})
public class Categoria extends DefaultEntity {

    @NotBlank
    @Column(nullable = false, length = 80)
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
