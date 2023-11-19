package com.tcc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Column(nullable = false)
    @JsonProperty
    private String nome;

    @Column(nullable = false)
    @JsonProperty
    private String cpf;

    @Column(nullable = false)
    @JsonProperty
    private String telefone;

    @Column(nullable = false)
    @JsonProperty
    private String email;

    @Column(nullable = false)
    @JsonProperty
    private String senha;

    @OneToOne
    @JsonProperty
    private Idioma idioma;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String telefone, String email, String senha, Idioma idioma) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.idioma = idioma;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}
