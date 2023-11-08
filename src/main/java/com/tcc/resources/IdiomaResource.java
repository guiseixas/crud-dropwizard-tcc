package com.tcc.resources;

import com.tcc.api.Idioma;
import com.tcc.db.IdiomaDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/idiomas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IdiomaResource {

    private IdiomaDAO idiomaDAO;

    public IdiomaResource(IdiomaDAO idiomaDAO) {
        this.idiomaDAO = idiomaDAO;
    }

    @GET
    public Response listaIdiomas() {
        List<Idioma> idiomas = idiomaDAO.listaIdiomas();
        return Response.ok(idiomas).build();
    }

    @GET
    @Path("/{id}")
    public Response getIdiomaById(@PathParam("id") Long id) {
        Idioma idioma = idiomaDAO.getIdiomaById(id);
        if(idioma == null) {
            throw new NotFoundException("Idioma nao encontrado");
        }
        return Response.ok(idioma).build();
    }

    @POST
    public Response salvaIdioma(Idioma idioma) {
        idiomaDAO.salvaIdioma(idioma);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response atualizaIdioma(Idioma idioma) {
        Idioma idiomaAtualizar = idiomaDAO.getIdiomaById(idioma.getId());
        if(idiomaAtualizar == null) {
            throw new NotFoundException("Idioma nao encontrado");
        }
        idiomaDAO.atualizaIdioma(idioma);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteIdiomaById(@PathParam("id") Long id) {
        Idioma idioma = idiomaDAO.getIdiomaById(id);
        if(idioma == null) {
            throw new NotFoundException("Idioma nao encontrado");
        }
        idiomaDAO.deleteById(id);
        return Response.ok().build();
    }
}
