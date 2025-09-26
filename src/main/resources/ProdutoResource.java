package org.acme.resource;

import org.acme.model.Produto;
import org.acme.repository.ProdutoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoRepository repository;

    @GET
    public List<Produto> listar() {
        return repository.listAll();
    }

    @POST
    @Transactional
    public Produto adicionar(Produto produto) {
        repository.persist(produto);
        return produto;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Produto atualizar(@PathParam("id") Long id, Produto produto) {
        Produto existente = repository.findById(id);
        if (existente == null) {
            throw new NotFoundException("Produto não encontrado");
        }
        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        existente.setQuantidade(produto.getQuantidade());
        return existente;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}
