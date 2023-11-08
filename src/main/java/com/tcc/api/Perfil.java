package com.tcc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Perfil {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    public Perfil() {
    }

    public Perfil(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
