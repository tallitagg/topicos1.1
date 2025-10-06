package org.acme.dto.response;

import org.acme.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(
        LocalDateTime dataPedido,
        ClienteResponseDTO cliente,
        List<ItemPedidoResponseDTO> itens,
        PagamentoResponseDTO pagamento,
        Double total
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> listaItemPedido = pedido.getItens()
                .stream()
                .map(ItemPedidoResponseDTO::valueOf)
                .toList();

        return new PedidoResponseDTO(
                pedido.getDataPedido(),
                ClienteResponseDTO.valueOf(pedido.getCliente()),
                listaItemPedido,
                PagamentoResponseDTO.valueOf(pedido.getPagamento()),
                pedido.getTotal()
        );
    }
}
