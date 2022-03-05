package com.company.oscar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coletor {
    public static List<Oscar> coletarOscaresArquivoCsv(String nomeArquivo) {
        try (Stream<String> lines = Files.lines(Paths.get(nomeArquivo))) {
            // O [.skip(1) é para pular o cabeçalho
            return lines.skip(1)
                    .map(Oscar::aPartirDaLinha)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<>();
    }
}
