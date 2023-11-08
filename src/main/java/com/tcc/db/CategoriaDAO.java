package com.tcc.db;

import com.tcc.api.Categoria;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(CategoriaMapper.class)
public interface CategoriaDAO {
    @SqlQuery("SELECT c.id AS categoria_id, c.nome AS categoria_nome, c.tag AS categoria_tag, " +
            "i.id AS idioma_id, i.nome AS idioma_nome, i.tag AS idioma_tag " +
            "FROM categoria c " +
            "JOIN idioma i ON c.idioma_id = i.id")
    List<Categoria> listaCategorias();

    @SqlQuery("SELECT c.*, i.id as idioma_id, i.nome as idioma_nome, i.tag as idioma_tag FROM categoria c " +
            "INNER JOIN idioma i ON c.idioma_id = i.id " +
            "WHERE c.id = :id")
    Categoria getCategoriaById(@Bind("id") Long id);

    @SqlUpdate("insert into categoria (nome, tag, idioma_id) VALUES (:nome, :tag, :idioma.id)\n")
    void salvaCategoria(@BindBean Categoria categoria);

    @SqlUpdate("UPDATE categoria SET nome = :nome, tag = :tag, idioma_id = :idioma.id WHERE id = :id")
    void atualizaCategoria(@BindBean Categoria categoria);

    @SqlUpdate("DELETE FROM categoria WHERE id = :id")
    void deleteById(@Bind("id") Long id);
}
