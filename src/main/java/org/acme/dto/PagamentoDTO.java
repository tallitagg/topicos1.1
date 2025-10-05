package org.acme.dto;

import org.acme.model.enums.StatusPagamento;

public record PagamentoDTO(
        PedidoDTO pedido,
        Double valor,
        StatusPagamento status,
        String metodo
) {
}
