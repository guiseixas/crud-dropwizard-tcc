package com.tcc.db;

import com.tcc.api.Categoria;
import com.tcc.api.Filme;
import com.tcc.api.Idioma;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

//Mapear o resultado da consulta SQL nas entidades e retornar como JSON
public class FilmeMapper implements RowMapper<Filme> {
    @Override
    public Filme map(ResultSet rs, StatementContext ctx) throws SQLException {
        Filme filme = new Filme();
        filme.setId(rs.getLong("id"));
        filme.setTitulo(rs.getString("titulo"));
        filme.setSinopse(rs.getString("sinopse"));
        filme.setImagem(rs.getString("imagem"));
        filme.setDataLancamento(rs.getString("dataLancamento"));
        filme.setDuracao(rs.getString("duracao"));
        filme.setIdioma(mapIdioma(rs));
        filme.setCategoria(mapCategoria(rs));
        return filme;
    }

    private Idioma mapIdioma(ResultSet rs) throws SQLException {
        Idioma idioma = new Idioma();
        idioma.setId(rs.getLong("idioma_id"));
        idioma.setNome(rs.getString("idioma_nome"));
        idioma.setTag(rs.getString("idioma_tag"));
        return idioma;
    }

    private Categoria mapCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNome(rs.getString("categoria_nome"));
        categoria.setTag(rs.getString("categoria_tag"));
        categoria.setIdioma(mapIdioma(rs));
        return categoria;
    }
}
