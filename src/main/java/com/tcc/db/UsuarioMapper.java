package com.tcc.db;

import com.tcc.api.Idioma;
import com.tcc.api.Usuario;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {
    @Override
    public Usuario map(ResultSet rs, StatementContext ctx) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.setCpf(rs.getString("cpf"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setTelefone(rs.getString("telefone"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setIdioma(mapIdioma(rs));
        usuario.setPerfis(null);
        return usuario;
    }

    private Idioma mapIdioma(ResultSet rs) throws SQLException {
        Idioma idioma = new Idioma();
        idioma.setId(rs.getLong("idioma_id"));
        idioma.setNome(rs.getString("idioma_nome"));
        idioma.setTag(rs.getString("idioma_tag"));
        return idioma;
    }
}
