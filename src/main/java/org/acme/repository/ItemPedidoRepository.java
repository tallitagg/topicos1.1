package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.ItemPedido;

import java.util.List;

public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {

    public List<ItemPedido> findByNomeProduto(String nomeProduto) {
        return find("UPPER(produto.nome)", "%" + nomeProduto + "%").firstResult();
    }

}
