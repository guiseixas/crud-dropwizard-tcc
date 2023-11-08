package com.tcc.db;

import com.tcc.api.Idioma;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(IdiomaMapper.class)
public interface IdiomaDAO {

    @SqlQuery("SELECT * FROM idioma")
    List<Idioma> listaIdiomas();

    @SqlQuery("SELECT * FROM idioma WHERE id = :id")
    Idioma getIdiomaById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO idioma (nome, tag) VALUES (:nome, :tag)")
    void salvaIdioma(@BindBean Idioma idioma);

    @SqlUpdate("UPDATE idioma SET nome = :nome, tag = :tag WHERE id = :id")
    void atualizaIdioma(@BindBean Idioma idioma);

    @SqlUpdate("DELETE FROM idioma WHERE id = :id")
    void deleteById(@Bind("id") Long id);
}
