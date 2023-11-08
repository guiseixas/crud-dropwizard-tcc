package com.tcc.db;

import com.tcc.api.Usuario;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(UsuarioMapper.class)
public interface UsuarioDAO {

    @SqlQuery("SELECT u.*, i.id as idioma_id, i.nome as idioma_nome, i.tag as idioma_tag " +
            "FROM usuario u " +
            "JOIN idioma i ON u.idioma_id = i.id")
    List<Usuario> listaUsuarios();

    @SqlQuery("SELECT u.*, i.id as idioma_id, i.nome as idioma_nome, i.tag as idioma_tag " +
            "FROM usuario u " +
            "JOIN idioma i ON u.idioma_id = i.id " +
            "WHERE u.id = :id")
    Usuario getUsuarioById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO usuario (nome, cpf, telefone, email, senha, idioma_id) values (:nome, :cpf, :telefone, :email, :senha, :idioma.id)")
    void salvaUsuario(@BindBean Usuario usuario);

    @SqlUpdate("UPDATE usuario SET nome = :nome, cpf = :cpf, telefone = :telefone, email = :email, senha = :senha, idioma_id = :idioma.id WHERE id = :id")
    void atualizaUsuario(@BindBean Usuario usuario);

    @SqlUpdate("DELETE FROM usuario WHERE id = :id")
    void deletaUsuarioById(@Bind("id") Long id);
}
