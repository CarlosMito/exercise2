package com.company.oscar;

import com.company.oscar.exceptions.AnoNegativoException;
import com.company.oscar.exceptions.NomeFilmeVazioException;

public class Oscar {
    private Interprete interprete;
    private String filme;

    // Não vejo motivos para utilizar LocalDate nesse atributo, pois a precisão
    // está em anos e não há restrições muito severas de data (além de valores negativos)
    private int ano;

    public Oscar(String filme, int ano, Interprete interprete) {
        this.setInterprete(interprete);
        this.setFilme((filme));
        this.setAno(ano);
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        if (filme == null || filme == "") throw new NomeFilmeVazioException();

        this.filme = filme;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano < 0) throw new AnoNegativoException(ano);

        this.ano = ano;
    }

    public Interprete getInterprete() {
        return interprete.copy();
    }

    public void setInterprete(Interprete interprete) {
        if (interprete == null) throw new NullPointerException();

        this.interprete = interprete.copy();
    }
}
