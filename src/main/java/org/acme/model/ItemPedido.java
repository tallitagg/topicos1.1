package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "item_pedido",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_item_pedido_pedido_variacao",
                        columnNames = {"pedido_id", "variacao_id"})
        })
public class ItemPedido extends DefaultEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_item_pedido_pedido"))
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "variacao_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_item_pedido_variacao"))
    private ProdutoVariacao variacao;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer quantidade;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Double precoUnitario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "fk_item_produto"))
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ProdutoVariacao getVariacao() {
        return variacao;
    }

    public void setVariacao(ProdutoVariacao variacao) {
        this.variacao = variacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
