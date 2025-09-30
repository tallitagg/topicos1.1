package org.acme.resources;

import org.acme.model.Categoria;
import org.acme.repository.CategoriaRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    CategoriaRepository categoriaRepository;

    @GET
    public List<Categoria> listar() {
        return categoriaRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Categoria buscarPorId(@PathParam("id") Long id) {
        return categoriaRepository.findById(id);
    }

    @POST
    @Transactional
    public Categoria adicionar(Categoria categoria) {
        categoriaRepository.persist(categoria);
        return categoria;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Categoria atualizar(@PathParam("id") Long id, Categoria categoria) {
        Categoria entity = categoriaRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException("Categoria não encontrada");
        }
        entity.setNome(categoria.getNome());
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id) {
        Categoria entity = categoriaRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException("Categoria não encontrada");
        }
        categoriaRepository.delete(entity);
    }
}
