package com.company.oscar.exceptions;

public class TempoNegativoException extends RuntimeException{
    public TempoNegativoException(int ano) {
        super(String.format("Essa medida de tempo não pode ser negativa [%d]", ano));
    }
}
