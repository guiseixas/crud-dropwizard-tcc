package com.tcc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String cpf;

    @JsonProperty
    private String telefone;

    @JsonProperty
    private String email;

    @JsonProperty
    private String senha;

    @JsonProperty
    private Idioma idioma;

    @JsonProperty
    private List<Perfil> perfis = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String telefone, String email, String senha, Idioma idioma, List<Perfil> perfis) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.idioma = idioma;
        this.perfis = perfis;
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

    public List<Perfil> getPerfis() {
        return perfis;
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

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }
}
