package org.acme.dto;

import org.acme.model.Produto;
import org.acme.model.ProdutoVariacao;
import org.acme.model.enums.Material;

public record ProdutoVariacaoResponseDTO(
        ProdutoResponseDTO produto,
        String sku,
        Integer capacidadeMl,
        Material material,
        String cor,
        Integer retencaoQuenteHoras,
        Integer retencaoFrioHoras,
        Boolean bpaFree,
        String tipoTampa,
        Double pesoKg,
        String dimensoes,
        Double Preco
) {
    public static ProdutoVariacaoResponseDTO valueOf(ProdutoVariacao produtoVariacao) {
        return new ProdutoVariacaoResponseDTO(
                ProdutoResponseDTO.valueOf(produtoVariacao.getProduto()),
                produtoVariacao.getSku(),
                produtoVariacao.getCapacidadeMl(),
                produtoVariacao.getMaterial(),
                produtoVariacao.getCor(),
                produtoVariacao.getRetencaoQuenteHoras(),
                produtoVariacao.getRetencaoFrioHoras(),
                produtoVariacao.getBpaFree(),
                produtoVariacao.getTipoTampa(),
                produtoVariacao.getPesoKg(),
                produtoVariacao.getDimensoes(),
                produtoVariacao.getPreco()
        );
    }
}
