package com.company.oscar;

import com.company.oscar.exceptions.IdentificadorVazioException;
import com.company.oscar.exceptions.TempoNegativoException;

public class Oscar {
    private Interprete interprete;
    private String filme;

    // Não vejo motivos para utilizar LocalDate nesse atributo, pois a precisão
    // está em anos e não há restrições muito severas de data (além de valores negativos)
    private int ano;

    public Oscar(int ano, Interprete interprete, String filme) {
        this.setInterprete(interprete);
        this.setFilme((filme));
        this.setAno(ano);
    }

    @Override
    public String toString() {
        return "Oscar{" +
                "interprete=" + interprete +
                ", filme='" + filme + '\'' +
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

    public Interprete getInterprete() {
        return interprete.clonar();
    }

    public void setInterprete(Interprete interprete) {
        if (interprete == null) throw new NullPointerException();

        this.interprete = interprete.clonar();
    }

    public static Oscar APartirDaLinha(String linha, Interprete.Sexo sexo) {
        String separator = ";";
            String[] campos = linha.split("[;\\.,\\t\\|](\\s)");

        return new Oscar(
            Integer.parseInt(campos[1]),
            new Interprete(Integer.parseInt(campos[2]), campos[3], sexo),
            campos[4]
        );
    }
}
