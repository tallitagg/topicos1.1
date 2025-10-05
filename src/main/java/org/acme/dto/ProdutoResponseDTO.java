package org.acme.dto;

import org.acme.model.Produto;

import java.util.List;

public record ProdutoResponseDTO(
        String nome,
        String descricao,
        FornecedorResponseDTO fornecedor,
        List<CategoriaResponseDTO> categorias,
        List<ProdutoVariacaoResponseDTO> variacoes,
        List<ItemPedidoResponseDTO> itens
) {
    public static ProdutoResponseDTO valueOf(Produto produto) {
        List<CategoriaResponseDTO> listaCategorias = produto.getCategorias()
                .stream()
                .map(CategoriaResponseDTO::valueOf)
                .toList();

        List<ProdutoVariacaoResponseDTO> listaProdutoVariacao = produto.getVariacoes()
                .stream()
                .map(ProdutoVariacaoResponseDTO::valueOf)
                .toList();

        List<ItemPedidoResponseDTO> listaItemPedido = produto.getItens()
                .stream()
                .map(ItemPedidoResponseDTO::valueOf)
                .toList();

        return new ProdutoResponseDTO(
                produto.getNome(),
                produto.getDescricao(),
                FornecedorResponseDTO.valueOf(produto.getFornecedor()),
                listaCategorias,
                listaProdutoVariacao,
                listaItemPedido
        );
    }
}
