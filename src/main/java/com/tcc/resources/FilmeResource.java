package com.tcc.resources;


import com.tcc.api.Filme;
import com.tcc.db.FilmeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filme")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilmeResource {

    private FilmeDAO filmeDAO;

    public FilmeResource(FilmeDAO filmeDAO) {
        this.filmeDAO = filmeDAO;
    }

    @GET
    public Response listaFilmes() {
        List<Filme> filmes = filmeDAO.listaFilmes();
        return Response.ok(filmes).build();
    }

    @GET
    @Path("/filmeById/{id}")
    public Response getFilmeById(@PathParam("id") Long id) {
        Filme filme = filmeDAO.getFilmeById(id);
        if(filme == null) {
            throw new NotFoundException("Filme nao encontrado");
        }
        return Response.ok(filme).build();
    }

    @POST
    public Response salvaFilme(Filme filme) {
        filmeDAO.saveFilme(filme);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response atualizaFilme(Filme filme) {
        Filme filmeatualizar = filmeDAO.getFilmeById(filme.getId());
        if(filmeatualizar == null) {
            throw new NotFoundException("Filme nao encontrado");
        }
        filmeDAO.atualizaFilme(filme);
        return Response.ok().build();
    }

    @DELETE
    @Path("/deleteFilmeById/{id}")
    public Response deleteFilmeById(@PathParam("id") Long id) {
        Filme filme = filmeDAO.getFilmeById(id);
        if(filme == null) {
            throw new RuntimeException("Filme nao encontrado");
        }
        filmeDAO.deleteById(id);
        return Response.ok().build();
    }
}
