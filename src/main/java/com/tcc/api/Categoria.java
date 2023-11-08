package com.tcc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Categoria {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String tag;

    private Idioma idioma;

    public Categoria() {
    }

    public Categoria(Long id, String nome, String tag, Idioma idioma) {
        this.id = id;
        this.nome = nome;
        this.tag = tag;
        this.idioma = idioma;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTag() {
        return tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}
