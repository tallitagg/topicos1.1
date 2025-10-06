package org.acme.dto.response;

import org.acme.model.Pagamento;
import org.acme.model.enums.MetodoPagamento;
import org.acme.model.enums.StatusPagamento;

public record PagamentoResponseDTO(
        PedidoResponseDTO pedido,
        Double valor,
        StatusPagamento status,
        MetodoPagamento metodoPagamento
) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        return new PagamentoResponseDTO(
                PedidoResponseDTO.valueOf(pagamento.getPedido()),
                pagamento.getValor(),
                pagamento.getStatus(),
                pagamento.getMetodo()
        );
    }
}
