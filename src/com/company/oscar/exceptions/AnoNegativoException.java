package com.company.oscar.exceptions;

public class AnoNegativoException extends RuntimeException{
    public AnoNegativoException(int ano) {
        super(String.format("Não existe ano negativo [%d]", ano));
    }
}
