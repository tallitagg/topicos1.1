package org.acme.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        LocalDateTime dataPedido,
        ClienteDTO cliente,
        List<ItemPedidoDTO> itens,
        PagamentoDTO pagamento,
        Double total
) {
}
