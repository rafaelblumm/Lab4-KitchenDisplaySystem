package restaurante;

import java.util.LinkedList;
import java.util.Queue;

public class Cozinha {
    private final Cardapio cardapio;
    private final Queue<Pedido> pedidos;

    public Cozinha(Cardapio cardapio) {
        this.cardapio = cardapio;
        this.pedidos = new LinkedList<>();
    }

    public Cardapio getCardapio() {
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
}
