package org.acme.dto;

import java.util.List;

public record EstoqueDTO(
        String local,
        Integer quantidade,
        List<ProdutoVariacaoDTO> variacao
) {
}
