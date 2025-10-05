package org.acme.resources;

import org.acme.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

//    @GET
//    public List<Pedido> listar() {
//        return Pedido.listAll();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Pedido buscarPorId(@PathParam("id") Long id) {
//        return Pedido.findById(id);
//    }
//
//    @POST
//    @Transactional
//    public Pedido criar(Pedido pedido) {
//        pedido.setDataPedido(LocalDateTime.now());
//
//        // calcular total automaticamente
//        double total = pedido.getProdutos().stream()
//                .mapToDouble(p -> p.getPreco())
//                .sum();
//        pedido.setTotal(total);
//
//        pedido.persist();
//        return pedido;
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Transactional
//    public Pedido atualizar(@PathParam("id") Long id, Pedido pedidoAtualizado) {
//        Pedido pedido = Pedido.findById(id);
//        if (pedido == null) {
//            throw new NotFoundException();
//        }
//
//        pedido.setCliente(pedidoAtualizado.getCliente());
//        pedido.setProdutos(pedidoAtualizado.getProdutos());
//
//        double total = pedidoAtualizado.getProdutos().stream()
//                .mapToDouble(p -> p.getPreco())
//                .sum();
//        pedido.setTotal(total);
//
//        pedido.persist();
//        return pedido;
//    }
//
//    @DELETE
//    @Path("/{id}")
//    @Transactional
//    public void deletar(@PathParam("id") Long id) {
//        Pedido pedido = Pedido.findById(id);
//        if (pedido == null) {
//            throw new NotFoundException();
//        }
//        pedido.delete();
//    }
}
