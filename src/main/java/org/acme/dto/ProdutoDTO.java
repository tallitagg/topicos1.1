package org.acme.dto;

import org.acme.model.Fornecedor;
import org.acme.model.ItemPedido;

import java.util.List;

public record ProdutoDTO(
        String nome,
        String descricao,
        Fornecedor fornecedor,
        List<CategoriaDTO> categorias,
        List<ProdutoVariacaoDTO> variacoes,
        List<ItemPedido> itens
) {
}
