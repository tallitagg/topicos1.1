package org.acme.dto;

import org.acme.model.Cliente;

import java.util.List;

public record ClienteResponseDTO(
        UsuarioResponseDTO usuario,
        List<ProdutoResponseDTO> listaDesejo,
        List<PedidoResponseDTO> pedidos
) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        List<ProdutoResponseDTO> listaProduto = cliente.getListaDesejo()
                .stream()
                .map(ProdutoResponseDTO::valueOf)
                .toList();

        List<PedidoResponseDTO> listaPedidos = cliente.getPedidos()
                .stream()
                .map(PedidoResponseDTO::valueOf)
                .toList();

        return new ClienteResponseDTO(
                UsuarioResponseDTO.valueOf(cliente.getUsuario()),
                listaProduto,
                listaPedidos
        );
    }
}
