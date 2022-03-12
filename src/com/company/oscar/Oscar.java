package com.company.oscar;

import com.company.oscar.exceptions.IdentificadorVazioException;
import com.company.oscar.exceptions.TempoNegativoException;

public class Oscar {
    private String filme;
    private String nome;

    // Não vejo motivos para utilizar LocalDate nesses atributos, pois a precisão
    // está em anos e não há restrições muito severas de data (além de valores negativos)
    private int idade;
    private int ano;

    public Oscar(int ano, int idade, String nome, String filme) {
        this.setAno(ano);
        this.setIdade(idade);
        this.setNome(nome);
        this.setFilme((filme));
    }

    @Override
    public String toString() {
        return "Oscar{" +
                "filme='" + filme + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", ano=" + ano +
                '}';
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        if (filme == null || filme.equals("")) throw new IdentificadorVazioException();

        this.filme = filme;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano < 0) throw new TempoNegativoException(ano);

        this.ano = ano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) throw new TempoNegativoException(idade);

        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.equals("")) throw new IdentificadorVazioException();

        this.nome = nome;
    }

    public static Oscar aPartirDaLinha(String linha) {
        String[] campos = linha.split("[;\\.,\\t\\|](\\s)*");

        return new Oscar(
            Integer.parseInt(campos[1]),
            Integer.parseInt(campos[2]),
            campos[3],
            campos[4]
        );
    }
}
