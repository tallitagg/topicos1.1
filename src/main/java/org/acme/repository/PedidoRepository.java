package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import org.acme.model.Cliente;
import org.acme.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoRepository implements PanacheRepository<Pedido> {

    public List<Pedido> findDateBetween(LocalDateTime inicio, LocalDateTime fim) {
        return find("dataPedido >= ?1 AND dataPedido <= ?2",
                Sort.by("dataPedido").ascending(), inicio, fim).firstResult();
    }

    public Pedido findByCliente (Cliente cliente){
        return find("UPPER(cliente.usuario.nome) LIKE ?1", "%" + cliente + "%").firstResult();
    }
}
