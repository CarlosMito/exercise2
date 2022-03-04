package com.company;

import com.company.oscar.Artista;
import com.company.oscar.Atriz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("oscar_age_female.csv"))) {
            List<String> linhas = ((stream.skip(1)).collect(Collectors.toList()));

            String separator = ";";

            for (String linha : linhas) {
                System.out.println(linha.split(";"));
                new Atriz("A", "A" , 10, 20, "F");


                List<Artista> resultado = new ArrayList<>();

                Map<String, Artista> dasd = resultado.map((Artista b) -> (Artista) b.getNome())
            }


//                List<OscarMasculino> oscarM = converterEmOscar(linhas);

            System.out.println(linhas);
//                oscarM.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

//	    String[] questions = new String[] {
//            "Quem foi o ator mais jovem a ganhar um Oscar?",
//            "Quem foi a atriz que mais vezes foi premiada?",
//            "Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?",
//            "Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes",
//            "Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a)."
//        };
//
//        String[] b = new String[] {"a", "b", "c"};
//        List<String> j;
//
//        Stream<String> a = Arrays.stream(b);
//
//        Integer[] c = new Integer[] {1, 2, 3, 4, 10, 6, 7, 8, 9, 10};
////        Integer[] c = new Integer[] {};
//        Stream<Integer> d = Arrays.stream(c);
//
////        d.reduce((Integer m, Integer n) -> )
////                        .ifPresent(System.out::println);
//
//        Integer maximum = d.max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
//
//        d = Arrays.stream(c);
//
//        d.filter((Integer e) -> e.equals(maximum)).forEach(System.out::println);
//
//        d.collect()


//        System.out.println(d.reduce((Integer m, Integer n) -> m + n));

//
//        for (int i = 1; i < questions.length + 1; i++) {
//            System.out.printf("[%d] %s\n", i , questions[i]);
//        }

    }

    public static void
}
