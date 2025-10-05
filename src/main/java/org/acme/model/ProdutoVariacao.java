package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.acme.model.enums.Material;
import java.util.List;

@Entity
@Table(name = "produto_variacao", uniqueConstraints = {
        @UniqueConstraint(name = "uk_variacao_sku", columnNames = "sku")
})
public class ProdutoVariacao extends DefaultEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_variacao_produto"))
    private Produto produto;

    @NotBlank
    @Column(nullable = false, length = 40)
    private String sku;

    @NotNull @Positive
    @Column(nullable = false)
    private Integer capacidadeMl;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Material material;

    @NotBlank
    @Column(nullable = false, length = 30)
    private String cor;

    @PositiveOrZero
    private Integer retencaoQuenteHoras;

    @PositiveOrZero
    private Integer retencaoFrioHoras;

    private Boolean bpaFree;
    private String tipoTampa;
    private Double pesoKg;
    private String dimensoes;

    @NotNull @PositiveOrZero
    @Column(nullable = false)
    private Double preco;

    // ESTE CAMPO PRECISA EXISTIR PARA CASAR COM mappedBy="estoque" EM Estoque
    @ManyToOne(optional = false)
    @JoinColumn(name = "estoque_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_variacao_estoque"))
    private Estoque estoque;

    @OneToMany(mappedBy = "variacao")
    private List<ItemPedido> itens;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getCapacidadeMl() {
        return capacidadeMl;
    }

    public void setCapacidadeMl(Integer capacidadeMl) {
        this.capacidadeMl = capacidadeMl;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getRetencaoQuenteHoras() {
        return retencaoQuenteHoras;
    }

    public void setRetencaoQuenteHoras(Integer retencaoQuenteHoras) {
        this.retencaoQuenteHoras = retencaoQuenteHoras;
    }

    public Integer getRetencaoFrioHoras() {
        return retencaoFrioHoras;
    }

    public void setRetencaoFrioHoras(Integer retencaoFrioHoras) {
        this.retencaoFrioHoras = retencaoFrioHoras;
    }

    public Boolean getBpaFree() {
        return bpaFree;
    }

    public void setBpaFree(Boolean bpaFree) {
        this.bpaFree = bpaFree;
    }

    public String getTipoTampa() {
        return tipoTampa;
    }

    public void setTipoTampa(String tipoTampa) {
        this.tipoTampa = tipoTampa;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(Double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
