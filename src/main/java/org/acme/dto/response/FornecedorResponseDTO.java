package org.acme.dto.response;

import org.acme.model.Fornecedor;

import java.util.List;

public record FornecedorResponseDTO(
        String nome,
        String cnpj,
        String telefone,
        String email,
        List<ProdutoResponseDTO> produtos
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
        List<ProdutoResponseDTO> listaProdutos = fornecedor.getProdutos()
                .stream()
                .map(ProdutoResponseDTO::valueOf)
                .toList();

        return new FornecedorResponseDTO(
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getTelefone(),
                fornecedor.getEmail(),
                listaProdutos
        );
    }
}
