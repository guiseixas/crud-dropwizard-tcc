package com.tcc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Idioma {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String tag;

    public Idioma() {
    }

    public Idioma(Long id, String nome, String tag) {
        this.id = id;
        this.nome = nome;
        this.tag = tag;
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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTag() {
        return tag;
    }
}
