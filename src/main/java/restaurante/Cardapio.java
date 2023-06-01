package restaurante;

import java.util.ArrayList;

public class Cardapio {
    private final ArrayList<Alimento> itens;

    public Cardapio(ArrayList<Alimento> itens) {
        this.itens = itens;
    }

    public ArrayList<Alimento> getItens() {
        return itens;
    }

    public String listaItens() {
        if (itens.isEmpty())
            return null;

        String linhaSeparadora = "+-------------------------------------------------------------------------------+\n";
        String cabecalho = "| ID  PRODUTO                                             VALOR     CATEGORIA   |\n" ;
        String titulo = "|                             C  A  R  D  A  P  I  O                            |\n";

        StringBuilder listagem = new StringBuilder();
        listagem.append(linhaSeparadora)
                .append(titulo)
                .append(linhaSeparadora)
                .append(cabecalho)
                .append(linhaSeparadora);

        int id = 0;
        for (Alimento alimento : itens)
            listagem.append("| ")
                    .append(++id < 10 ? " " + id : id)
                    .append("  ")
                    .append(alimento.toListagem())
                    .append(" |\n");

        listagem.append(linhaSeparadora);

        return listagem.toString();
    }
}
