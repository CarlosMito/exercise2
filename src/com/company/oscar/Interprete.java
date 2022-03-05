package com.company.oscar;

import com.company.oscar.exceptions.IdentificadorVazioException;
import com.company.oscar.exceptions.TempoNegativoException;

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
