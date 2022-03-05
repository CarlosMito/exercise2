package com.company;

import com.company.oscar.Interprete;
import com.company.oscar.Oscar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO: Testar as exceções.
 */

public class Aplicacao {

    // Mesmo podendo utilizar uma Interface Funcional presente na java.util.function,
    // preferi criar uma Interface própria para ser mais preciso semanticamente.

    @FunctionalInterface
    public interface Respondivel {
        void responder();
    }

    private List<Oscar> oscares = new ArrayList<>();

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();

        // TODO: Repensar essa maneira de ler oarquivos CSV. Está com uma semântica estranha.
        app.criarOscaresDeArquivoCsv("oscar_age_male.csv", Interprete.Sexo.MASCULINO);
        app.criarOscaresDeArquivoCsv("oscar_age_female.csv", Interprete.Sexo.FEMININO);

        System.out.println(app.oscares.get(0));

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

    private void criarOscaresDeArquivoCsv(String nomeArquivo, Interprete.Sexo sexo) {
//        getCaminhoArquivo(nomeArquivo);

        try (Stream<String> lines = Files.lines(Paths.get(nomeArquivo))) {

            List<Oscar> a = lines.skip(1)
                    .map((String l) -> Oscar.aPartirDaLinha(l, sexo))
                    .collect(Collectors.toList());

            this.oscares = Stream.concat(this.oscares.stream(), a.stream())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getCaminhoArquivo(String nomeArquivo) {
//        URL url = getClass().getClassLoader().getResource(nomeArquivo);
        System.out.println(getClass().getClassLoader().getResource(nomeArquivo));

//            for (String linha : linhas) {
//                System.out.println(linha.split(";"));
//                new Atriz("A", "A" , 10, 20, "F");
//
//
//                List<Interprete> resultado = new ArrayList<>();
//
//                Map<String, Interprete> dasd = resultado.map((Interprete b) -> (Interprete) b.getNome())
//            }

        return "";
    }

    private void questao1() {
        System.out.println("[1] Quem foi o ator mais jovem a ganhar um Oscar?");

        this.oscares.stream()
                .filter((Oscar o) -> o.getInterprete().getSexo() == Interprete.Sexo.MASCULINO)
                .min(Comparator.comparingInt((Oscar o) -> o.getInterprete().getIdade()))
                .ifPresent((Oscar o) -> System.out.println(o.getInterprete()));
    }

    // TODO: Criar uma classe para ler e transformar (leitura pública e transformação privada)

    private void questao2() {
        System.out.println( "[2] Quem foi a atriz que mais vezes foi premiada?");

        Map<String, Long> contagemOscares = this.oscares.stream()
                .map((Oscar o) -> o.getInterprete().getNome())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        contagemOscares.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(System.out::println);
    }

    private void questao3() {
        System.out.println("[3] Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?");
    }

    private void questao4() {
        System.out.println("[4] Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes");
    }

    private void questao5() {
        System.out.println("[5] Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a).");
    }



//        try (Stream<String> stream = Files.lines(Paths.get("oscar_age_female.csv"))) {
//            List<String> linhas = ((stream.skip(1)).collect(Collectors.toList()));
//
//            String separator = ";";
//
//            for (String linha : linhas) {
//                System.out.println(linha.split(";"));
//                new Atriz("A", "A" , 10, 20, "F");
//
//
//                List<Interprete> resultado = new ArrayList<>();
//
//                Map<String, Interprete> dasd = resultado.map((Interprete b) -> (Interprete) b.getNome())
//            }
//
//
////                List<OscarMasculino> oscarM = converterEmOscar(linhas);
//
//            System.out.println(linhas);
////                oscarM.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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

//    }
}
