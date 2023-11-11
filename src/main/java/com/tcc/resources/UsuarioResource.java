package com.tcc.resources;

import com.tcc.api.Usuario;
import com.tcc.db.UsuarioDAO;
import org.jdbi.v3.sqlobject.customizer.BindBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioDAO usuarioDAO;

    public UsuarioResource(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @GET
    public Response listaUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listaUsuarios();
        return Response.ok(usuarios).build();
    }

    @GET
    @Path("/usuarioById/{id}")
    public Response findUsuarioById(@PathParam("id") Long id) {
        Usuario usuario = usuarioDAO.getUsuarioById(id);
        if(usuario == null) {
            throw new NotFoundException("Usuario nao encontrado");
        }
        return Response.ok(usuario).build();
    }

    @POST
    public Response salvaUsuario(@BindBean Usuario usuario) {
        usuarioDAO.salvaUsuario(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response atualizaUsuario(@BindBean Usuario usuario) {
        Usuario usuarioAtualizar = usuarioDAO.getUsuarioById(usuario.getId());
        if(usuarioAtualizar == null) {
            throw new NotFoundException("Usuario nao encontrado");
        }
        usuarioDAO.atualizaUsuario(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/deleteUsuarioById/{id}")
    public Response deleteUserById(@PathParam("id") Long id) {
        Usuario usuarioDeletar = usuarioDAO.getUsuarioById(id);
        if(usuarioDeletar == null) {
            throw new NotFoundException("Usuario nao encontrado");
        }
        usuarioDAO.deletaUsuarioById(id);
        return Response.ok().build();
    }
}
