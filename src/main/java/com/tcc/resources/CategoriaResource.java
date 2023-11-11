package com.tcc.resources;

import com.tcc.api.Categoria;
import com.tcc.db.CategoriaDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    private CategoriaDAO categoriaDAO;

    public CategoriaResource(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @GET
    public Response listaCategorias() {
        List<Categoria> categorias = categoriaDAO.listaCategorias();
        return Response.ok(categorias).build();
    }

    @GET
    @Path("/categoriaById/{id}")
    public Response getCategoriaById(@PathParam("id") Long id) {
        Categoria categoria = categoriaDAO.getCategoriaById(id);
        if(categoria == null) {
            throw new NotFoundException("Categoria nao encontrada");
        }
        return Response.ok(categoria).build();
    }

    @POST
    public Response salvaCategoria(Categoria categoria) {
        categoriaDAO.salvaCategoria(categoria);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response atualizaCategoria(Categoria categoria) {
        Categoria categoriaAtualizar = categoriaDAO.getCategoriaById(categoria.getId());
        if(categoriaAtualizar == null) {
            throw new NotFoundException("Categoria nao encontrada");
        }
        categoriaDAO.atualizaCategoria(categoria);
        return Response.ok().build();
    }

    @DELETE
    @Path("/deleteCategoriaById/{id}")
    public Response deleteCategoriaById(@PathParam("id") Long id) {
        Categoria categoria = categoriaDAO.getCategoriaById(id);
        if(categoria == null) {
            throw new NotFoundException("Categoria nao encontrada");
        }
        categoriaDAO.deleteById(id);
        return Response.ok().build();
    }
}
