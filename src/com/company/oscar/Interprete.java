package com.company.oscar;


public class Interprete {
    private int idade;
    private String nome;

    public Interprete(int idade, String nome) {
    }

    public Interprete(Interprete copy) {
        this.idade = copy.idade;
        this.nome = copy.nome;
    }

    public Interprete clonar() {
        return new Interprete(this);
    }
}
