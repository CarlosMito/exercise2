package com.company.oscar;

import com.company.oscar.exceptions.IdentificadorVazioException;
import com.company.oscar.exceptions.TempoNegativoException;

public class Interprete {
    public enum Sexo {MASCULINO, FEMININO}

    private int idade;
    private String nome;
    private Sexo sexo;

    public Interprete(int idade, String nome, Sexo sexo) {
        this.setIdade(idade);
        this.setNome(nome);
        this.sexo = sexo;
    }

    public Interprete(Interprete copy) {
        this.idade = copy.idade;
        this.nome = copy.nome;
        this.sexo = copy.sexo;
    }

    public Interprete clonar() {
        return new Interprete(this);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) throw new TempoNegativoException(idade);

        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.equals("")) throw new IdentificadorVazioException();

        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Interprete{" +
                "idade=" + idade +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                '}';
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
