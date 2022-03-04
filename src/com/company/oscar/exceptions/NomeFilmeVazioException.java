package com.company.oscar.exceptions;

public class NomeFilmeVazioException extends RuntimeException {
    public NomeFilmeVazioException() {
        super("O nome do filme não pode ser vazio");
    }
}
