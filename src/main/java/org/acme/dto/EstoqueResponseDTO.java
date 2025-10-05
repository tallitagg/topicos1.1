package org.acme.dto;

import org.acme.model.Estoque;

import java.util.List;

public record EstoqueResponseDTO(
        String local,
        Integer quantidade,
        List<ProdutoVariacaoResponseDTO> variacao
) {
    public static EstoqueResponseDTO valueOf(Estoque estoque) {
        List<ProdutoVariacaoResponseDTO> listaProdutoVariacao = estoque.getVariacoes()
                .stream()
                .map(ProdutoVariacaoResponseDTO::valueOf)
                .toList();

        return new EstoqueResponseDTO(
                estoque.getLocal(),
                estoque.getQuantidade(),
                listaProdutoVariacao
        );
    }
}
