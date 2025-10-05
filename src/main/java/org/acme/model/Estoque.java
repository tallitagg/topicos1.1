package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "estoque")
public class Estoque extends DefaultEntity {

    @NotBlank
    @Column(nullable = false, length = 120)
    private String local;

    @NotNull
    @Column(nullable = false)
    private Integer quantidade;

    // lado inverso da relação (o dono é ProdutoVariacao.estoque)
    @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoVariacao> variacoes;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<ProdutoVariacao> getVariacoes() {
        return variacoes;
    }

    public void setVariacoes(List<ProdutoVariacao> variacoes) {
        this.variacoes = variacoes;
    }
}
