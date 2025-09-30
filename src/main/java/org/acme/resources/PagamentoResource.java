package org.acme.resources;

import org.acme.model.Pagamento;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @GET
    public List<Pagamento> listar() {
        return Pagamento.listAll();
    }

    @GET
    @Path("/{id}")
    public Pagamento buscarPorId(@PathParam("id") Long id) {
        return Pagamento.findById(id);
    }

    @POST
    @Transactional
    public Pagamento criar(Pagamento pagamento) {
        // Se não definir manualmente, o valor pode ser puxado do pedido
        if (pagamento.getValor() == null && pagamento.getPedido() != null) {
            pagamento.setValor(pagamento.getPedido().getTotal());
        }
        pagamento.persist();
        return pagamento;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Pagamento atualizar(@PathParam("id") Long id, Pagamento pagamentoAtualizado) {
        Pagamento pagamento = Pagamento.findById(id);
        if (pagamento == null) {
            throw new NotFoundException();
        }

        pagamento.setPedido(pagamentoAtualizado.getPedido());
        pagamento.setValor(pagamentoAtualizado.getValor());
        pagamento.setFormaPagamento(pagamentoAtualizado.getFormaPagamento());
        pagamento.setStatus(pagamentoAtualizado.getStatus());

        pagamento.persist();
        return pagamento;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id) {
        Pagamento pagamento = Pagamento.findById(id);
        if (pagamento == null) {
            throw new NotFoundException();
        }
        pagamento.delete();
    }
}
