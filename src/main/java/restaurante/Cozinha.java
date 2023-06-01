package restaurante;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe que representa cozinha, com cardápio de itens e manutenção de fila de pedidos.
 */
public class Cozinha {
    private final Cardapio cardapio;
    private final Queue<Pedido> pedidos;

    public Cozinha(Cardapio cardapio) {
        this.cardapio = cardapio;
        this.pedidos = new LinkedList<>();
    }

    /**
     * Retorna cardápio.
     * @return Cardápio.
     */
    public Cardapio getCardapio() {
        return cardapio;
    }

    /**
     * Retorna fila de pedidos.
     * @return Fila de pedidos.
     */
    public Queue<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Adiciona novo pedido no fim da fila de pedidos.
     * @param pedido Pedido a ser adicionado.
     * @return Condição de sucesso.
     */
    public boolean adicionaPedido(Pedido pedido) {
        if (pedido == null || pedido.getItens().isEmpty())
            return false;

        return pedidos.add(pedido);
    }

    /**
     * Exibe primeiro pedido da fila.
     * @return Primeiro pedido da fila.
     */
    public Pedido exibePrimeiroPedido() {
        return pedidos.peek();
    }

    /**
     * Entrega e elimina primeiro pedido da fila.
     * @return Primeiro pedido da fila.
     */
    public Pedido entregaPedido() {
        return pedidos.isEmpty() ? null : pedidos.remove();
    }

    /**
     * Lista todos os pedidos da fila de pedidos.
     * @return Listagem dos pedidos.
     */
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
