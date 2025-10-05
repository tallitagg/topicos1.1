package org.acme.dto;

import java.util.List;

public record ClienteDTO(
        UsuarioDTO usuario,
        List<ProdutoDTO> listaDesejo,
        List<PedidoDTO> pedidos
) {
}