package org.acme.dto;

import org.acme.model.enums.Material;

public record ProdutoVariacaoDTO(
        ProdutoDTO produto,
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
}
