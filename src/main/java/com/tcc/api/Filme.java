package com.tcc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Column(nullable = false)
    @JsonProperty
    private String titulo;

    @Column(nullable = false)
    @JsonProperty
    private String sinopse;

    @JsonProperty
    private String imagem;

    @Column(nullable = false)
    @JsonProperty
    private String dataLancamento;

    @Column(nullable = false)
    @JsonProperty
    private String duracao;

    @ManyToOne
    private Idioma idioma;

    @ManyToOne
    private Categoria categoria;

    public Filme() {
    }

    public Filme(Long id, String titulo, String sinopse, String imagem, String dataLancamento, String duracao, Idioma idioma, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.imagem = imagem;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.idioma = idioma;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
