package com.tcc.db;

import com.tcc.api.Filme;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(FilmeMapper.class)
public interface FilmeDAO {
    @SqlQuery("SELECT f.id as filme_id, f.titulo as filme_titulo, f.sinopse as filme_sinopse, f.imagem as filme_imagem, " +
            "f.dataLancamento as filme_dataLancamento, f.duracao as filme_duracao, " +
            "i.id as idioma_id, i.nome as idioma_nome, i.tag as idioma_tag," +
            "c.id as categoria_id, c.nome as categoria_nome, c.tag as categoria_tag " +
            "FROM filme f " +
            "JOIN idioma i ON f.idioma_id = i.id " +
            "JOIN categoria c ON f.categoria_id = c.id")
    List<Filme> listaFilmes();
    @SqlQuery("SELECT f.id as filme_id, f.titulo as filme_titulo, f.sinopse as filme_sinopse, f.imagem as filme_imagem, " +
            "f.dataLancamento as filme_dataLancamento, f.duracao as filme_duracao, " +
            "i.id as idioma_id, i.nome as idioma_nome, i.tag as idioma_tag," +
            "c.id as categoria_id, c.nome as categoria_nome, c.tag as categoria_tag " +
            "FROM filme f " +
            "JOIN idioma i ON f.idioma_id = i.id " +
            "JOIN categoria c ON f.categoria_id = c.id " +
            "WHERE f.id = :id")
    Filme getFilmeById(@Bind("id") Long id);

    @SqlUpdate("insert into filme (titulo, sinopse, imagem, dataLancamento, duracao, idioma_id, categoria_id) values (:titulo, :sinopse, :imagem, :dataLancamento, :duracao, :idioma.id, :categoria.id)")
    void saveFilme(@BindBean Filme filme);

    @SqlUpdate("UPDATE filme SET " +
            "titulo = :titulo, " +
            "sinopse = :sinopse, " +
            "imagem = :imagem, " +
            "dataLancamento = :dataLancamento, " +
            "duracao = :duracao, " +
            "idioma_id = :idioma.id, " +
            "categoria_id = :categoria.id " +
            "WHERE id = :id")
    void atualizaFilme(@BindBean Filme filme);

    @SqlUpdate("DELETE FROM filme WHERE id = :id")
    void deleteById(@Bind("id") Long id);
}
