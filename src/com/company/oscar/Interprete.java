package com.company.oscar;

public class Interprete {
    public enum Sexo {MASCULINO, FEMININO}

    private int idade;
    private String nome;
    private Sexo sexo;

    public Interprete(int idade, String nome, Sexo sexo) {
        this.idade = idade;
        this.nome = nome;
        this.sexo = sexo;
    }

    public Interprete(Interprete copy) {
        this.idade = copy.idade;
        this.nome = copy.nome;
        this.sexo = copy.sexo;
    }

    public Interprete copy() {
        return new Interprete(this);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
