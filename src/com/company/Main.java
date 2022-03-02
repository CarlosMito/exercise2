package com.company;

public class Main {

    public static void main(String[] args) {
	    String[] questions = new String[] {
            "Quem foi o ator mais jovem a ganhar um Oscar?",
            "Quem foi a atriz que mais vezes foi premiada?",
            "Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?",
            "Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes",
            "Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a)."
        };

        for (int i = 1; i < questions.length + 1; i++) {
            System.out.printf("[%d] %s\n", i , questions[i]);
        }
    }
}
