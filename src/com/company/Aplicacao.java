package com.company;

import com.company.oscar.Coletor;
import com.company.oscar.Oscar;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Aplicacao {

    // Mesmo podendo utilizar uma Interface Funcional presente na java.util.function,
    // preferi criar uma Interface própria para ser mais preciso semanticamente.

    @FunctionalInterface
    public interface Respondivel {
        void responder();
    }

    private List<Oscar> oscaresAtores;
    private List<Oscar> oscaresAtrizes;

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();

        app.oscaresAtores = Coletor.coletarOscaresArquivoCsv("oscar_age_male.csv");
        app.oscaresAtrizes = Coletor.coletarOscaresArquivoCsv("oscar_age_female.csv");

        Respondivel[] questoes = new Respondivel[] {
            app::questao1,
            app::questao2,
            app::questao3,
            app::questao4,
            app::questao5
        };

        for (Respondivel questao : questoes) {
            questao.responder();
            System.out.println();
        }
    }

    private void imprimirResposta(Oscar oscar) {
        System.out.printf("Nome: %s - Idade: %d\n", oscar.getNome(), oscar.getIdade());
    }

    private void imprimirResposta(Map.Entry<String, Long> contagem) {
        System.out.printf("Nome: %s - Oscares: %d\n", contagem.getKey(), contagem.getValue());
    }

    private void imprimirOscarSemNome(Oscar o) {
        System.out.printf("\tFilme: %s - Ano: %d - Idade: %d\n", o.getFilme(), o.getAno(), o.getIdade());
    }

    private void questao1() {
        System.out.println("[1] Quem foi o ator mais jovem a ganhar um Oscar?");

        this.oscaresAtores.stream().skip(1)
                .min(Comparator.comparingInt(Oscar::getIdade))
                .ifPresent(this::imprimirResposta);
    }

    private void questao2() {
        System.out.println( "[2] Quem foi a atriz que mais vezes foi premiada?");

        this.oscaresAtrizes.stream()
                .map(Oscar::getNome)
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(this::imprimirResposta);
    }

    private void questao3() {
        System.out.println("[3] Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?");

        this.oscaresAtrizes.stream()
                .filter((Oscar o) -> o.getIdade() >= 20 && o.getIdade() <= 30)
                .map(Oscar::getNome)
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(this::imprimirResposta);
    }

    private void questao4() {
        System.out.println("[4] Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes");

        List<Oscar> oscares = Stream.concat(
                    this.oscaresAtores.stream(),
                    this.oscaresAtrizes.stream()
                ).collect(Collectors.toList());

        oscares.stream()
                .map(Oscar::getNome)
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter((Map.Entry<String, Long> m) -> m.getValue() > 1)
                .forEach(this::imprimirResposta);
    }

    private void questao5() {
        System.out.println("[5] Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a).");

        System.out.print("Insira o nome do intérprete: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        // Define word boundaries para evitar que encontre o padrão em parte do nome do intérprete
        String pattern = input.isEmpty() ? "" : String.format("(?i).*\\b(%s)\\b.*", input);

        List<Oscar> oscares = Stream.concat(
                this.oscaresAtores.stream(),
                this.oscaresAtrizes.stream()
        ).collect(Collectors.toList());

        List<Oscar> filtrado = oscares.stream()
                .filter((Oscar o) -> o.getNome().matches(pattern))
                .collect(Collectors.toList());

        if (filtrado.isEmpty())
            System.out.println("\nNão foi encontrado nenhum intérprete com esse nome!");

        else {
            filtrado.stream()
                    .collect(groupingBy(Oscar::getNome))
                    .forEach((key, os) -> {
                        System.out.printf("\nNome: %s (Total: %d)\n", key, os.size());
                        os.forEach(this::imprimirOscarSemNome);
                    });
        }
    }
}
