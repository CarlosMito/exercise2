package com.company.oscar.exceptions;

public class IdentificadorVazioException extends RuntimeException {
    public IdentificadorVazioException() {
        super("A etiqueta de identificação não pode estar vazia");
    }
}
