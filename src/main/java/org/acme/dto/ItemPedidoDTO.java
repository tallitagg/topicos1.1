package org.acme.dto;

public record ItemPedidoDTO(
    PedidoDTO pedido,
    ProdutoVariacaoDTO variacao,
    Integer quantidade,
    Double precoUnitario,
    ProdutoDTO produto
) {
}
