package restaurante;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cozinha {
    private final ArrayList<Alimento> cardapio;
    private Queue<Pedido> pedidos;

    public Cozinha(ArrayList<Alimento> cardapio) {
        this.cardapio = cardapio;
        this.pedidos = new LinkedList<>();
    }

    public ArrayList<Alimento> getCardapio() {
        return cardapio;
    }

    public Queue<Pedido> getPedidos() {
        return pedidos;
    }

    public boolean adicionaPedido(Pedido pedido) {
        if (pedido == null || pedido.getItens().isEmpty())
            return false;

        return pedidos.add(pedido);
    }

    public Pedido exibePrimeiroPedido() {
        return pedidos.peek();
    }

    public Pedido entregaPedido() {
        return pedidos.isEmpty() ? null : pedidos.remove();
    }

    public String listaPedidos() {
        if (pedidos.isEmpty())
            return null;

        StringBuilder listagem = new StringBuilder();

        String linhaSeparadora = "+---------------------------------------------------------------------------+\n";
        String titulo = "|                            P  E  D  I  D  O  S                            |\n";

        listagem.append(linhaSeparadora)
                .append(titulo)
                .append(linhaSeparadora)
                .append("\n");

        for (Pedido pedido : pedidos)
            listagem.append(pedido.exibePedido())
                    .append("\n");

        return listagem.isEmpty() ? null : listagem.toString();
    }

    public String listaItensCardapio() {
        if (cardapio.isEmpty())
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
        for (Alimento alimento : cardapio)
            listagem.append("| ")
                    .append(++id < 10 ? " " + id : id)
                    .append("  ")
                    .append(alimento.toListagem())
                    .append(" |\n");

        listagem.append(linhaSeparadora);

        return listagem.toString();
    }
}
