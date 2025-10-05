package org.acme.dto;

import org.acme.model.ItemPedido;

public record ItemPedidoResponseDTO(
        PedidoResponseDTO pedido,
        ProdutoVariacaoResponseDTO variacao,
        Integer quantidade,
        Double precoUnitario,
        ProdutoResponseDTO produto
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO(
                PedidoResponseDTO.valueOf(itemPedido.getPedido()),
                ProdutoVariacaoResponseDTO.valueOf(itemPedido.getVariacao()),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario(),
                ProdutoResponseDTO.valueOf(itemPedido.getProduto())
        );
    }
}
