package org.acme.dto;

import org.acme.model.enums.MetodoPagamento;
import org.acme.model.enums.StatusPagamento;

public record PagamentoDTO(
        PedidoDTO pedido,
        Double valor,
        StatusPagamento status,
        MetodoPagamento metodo
) {
}
