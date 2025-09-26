package org.acme.resources;
package org.acme.resource;

import org.acme.model.Cliente;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @GET
    public List<Cliente> listar() {
        return Cliente.listAll();
    }

    @GET
    @Path("/{id}")
    public Cliente buscarPorId(@PathParam("id") Long id) {
        return Cliente.findById(id);
    }

    @POST
    @Transactional
    public Cliente criar(Cliente cliente) {
        cliente.persist();
        return cliente;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cliente atualizar(@PathParam("id") Long id, Cliente clienteAtualizado) {
        Cliente cliente = Cliente.findById(id);
        if (cliente == null) {
            throw new NotFoundException();
        }

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setSenha(clienteAtualizado.getSenha());
        cliente.setEndereco(clienteAtualizado.getEndereco());

        cliente.persist();
        return cliente;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id) {
        Cliente cliente = Cliente.findById(id);
        if (cliente == null) {
            throw new NotFoundException();
        }
        cliente.delete();
    }
}
