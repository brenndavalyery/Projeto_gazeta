package com.example.exercicioGazeta.model;

public class tarefaModel {
    private String nome;
    private String descricao;
    private String data;
    private String sobrenome;

    public tarefaModel() {
    }

    public tarefaModel(String nome, String descricao, String data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getSobrenome() {return sobrenome; }
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome; }
}
