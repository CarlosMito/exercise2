package com.company.oscar;

public class Artista {
    protected int idade;
    protected int ano;
    protected String nome;
    protected String filme;

    private String genero;

    public Artista(String nome, String filme, int ano, int idade, String genero) {

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFilme() {
        return this.filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }
}
