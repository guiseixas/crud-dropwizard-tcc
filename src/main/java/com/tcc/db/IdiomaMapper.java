package com.tcc.db;

import com.tcc.api.Idioma;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdiomaMapper implements RowMapper<Idioma> {
    @Override
    public Idioma map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Idioma(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getString("tag")
        );
    }
}
