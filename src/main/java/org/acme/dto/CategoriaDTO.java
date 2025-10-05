package org.acme.dto;

import java.util.List;

public record CategoriaDTO(
        String nome,
        List<ProdutoDTO> produto
) {
}
