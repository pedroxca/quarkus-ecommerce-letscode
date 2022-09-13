package com.letscode.api.v1;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import com.letscode.ecommerce.entity.Produto;
import com.letscode.ecommerce.services.ProdutoService;

@Path("/api/v1/produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoController {
    
    @Inject
    ProdutoService produtoService;
    
    @Operation(description = "Salvar um produto")
    
    @POST
    public Response salvar(@Valid Produto produto) {
        
        return Response.ok(produtoService.createProduto(produto)).build();
    }
    
    @Operation(description = "Atualizar um produto")
    
    @PUT
    public Response atualizar(@Valid Produto produto) {
        return Response.ok(produtoService.updateProduto(produto)).build();
    }
    
    @Operation(description = "Retorna todos os clientes")
    
    @GET
    public Response listarTodos() {
        return Response.ok(produtoService.getProdutos()).build();
    }
    
    @Operation(description = "Retorna produto pelo id")
    
    @GET
    @Path("/{id}")
    public Response listarPorId(@PathParam("id") Long id) {
        return Response.ok(produtoService.getProdutoById(id)).build();
    }
    
    @Operation(description = "Excluir um produto")
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {

        produtoService.deleteProduto(id);
    }
}
