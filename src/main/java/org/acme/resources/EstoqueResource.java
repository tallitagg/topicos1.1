package org.acme.resources;

import org.acme.model.Estoque;
import org.acme.repository.EstoqueRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/estoques")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstoqueResource {

    @Inject
    EstoqueRepository estoqueRepository;

    @GET
    public List<Estoque> listar() {
        return estoqueRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Estoque buscarPorId(@PathParam("id") Long id) {
        return estoqueRepository.findById(id);
    }

    @POST
    @Transactional
    public Estoque adicionar(Estoque estoque) {
        estoqueRepository.persist(estoque);
        return estoque;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Estoque atualizar(@PathParam("id") Long id, Estoque estoque) {
        Estoque entity = estoqueRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException("Estoque não encontrado");
        }
        entity.setLocal(estoque.getLocal());
        entity.setQuantidade(estoque.getQuantidade());
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id) {
        Estoque entity = estoqueRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException("Estoque não encontrado");
        }
        estoqueRepository.delete(entity);
    }
}
