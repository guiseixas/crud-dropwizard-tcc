package com.tcc.db;

import com.tcc.api.Categoria;
import com.tcc.api.Idioma;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {
    @Override
    public Categoria map(ResultSet rs, StatementContext ctx) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id"));
        categoria.setNome(rs.getString("nome"));
        categoria.setTag(rs.getString("tag"));
        categoria.setIdioma(mapIdioma(rs));
        return categoria;
    }

    private Idioma mapIdioma(ResultSet rs) throws SQLException {
        Idioma idioma = new Idioma();
        idioma.setId(rs.getLong("idioma_id"));
        idioma.setNome(rs.getString("idioma_nome"));
        idioma.setTag(rs.getString("idioma_tag"));
        return idioma;
    }
}
