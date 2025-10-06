package org.acme.dto.response;

import org.acme.model.Categoria;

import java.util.List;

public record CategoriaResponseDTO(
        String nome,
        List<ProdutoResponseDTO> produto
) {
    public static CategoriaResponseDTO valueOf(Categoria categoria) {
        List<ProdutoResponseDTO> listaProdutos = categoria.getProdutos()
                .stream()
                .map(ProdutoResponseDTO::valueOf)
                .toList();

        return new CategoriaResponseDTO(
                categoria.getNome(),
                listaProdutos
        );
    }
}
