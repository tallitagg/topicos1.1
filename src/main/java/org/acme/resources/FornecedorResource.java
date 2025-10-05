package org.acme.resources;

import org.acme.model.Fornecedor;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

//    @GET
//    public List<Fornecedor> listar() {
//        return Fornecedor.listAll();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Fornecedor buscarPorId(@PathParam("id") Long id) {
//        return Fornecedor.findById(id);
//    }
//
//    @POST
//    @Transactional
//    public Fornecedor criar(Fornecedor fornecedor) {
//        fornecedor.persist();
//        return fornecedor;
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Transactional
//    public Fornecedor atualizar(@PathParam("id") Long id, Fornecedor fornecedorAtualizado) {
//        Fornecedor fornecedor = Fornecedor.findById(id);
//        if (fornecedor == null) {
//            throw new NotFoundException();
//        }
//
//        fornecedor.setNome(fornecedorAtualizado.getNome());
//        fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
//        fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
//        fornecedor.setEmail(fornecedorAtualizado.getEmail());
//        fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
//
//        fornecedor.persist();
//        return fornecedor;
//    }
//
//    @DELETE
//    @Path("/{id}")
//    @Transactional
//    public void deletar(@PathParam("id") Long id) {
//        Fornecedor fornecedor = Fornecedor.findById(id);
//        if (fornecedor == null) {
//            throw new NotFoundException();
//        }
//        fornecedor.delete();
//    }
}
