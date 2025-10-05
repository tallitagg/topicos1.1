package org.acme.dto;

import java.util.List;

public record FornecedorDTO(
        String nome,
        String cnpj,
        String telefone,
        String email,
        List<ProdutoDTO> produtos
) {
}
