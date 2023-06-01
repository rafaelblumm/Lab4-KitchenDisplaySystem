package restaurante;

import utils.Tupla;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * Classe que representa pedido do usuário.
 */
public class Pedido {
    public static final int MAX_QUANTIDADE = 15;
    private final int codigo;
    private final ArrayList<Tupla<Alimento, Integer>> itens;

    public Pedido(int codigo) {
        this.codigo = codigo;
        this.itens = new ArrayList<>();
    }

    /**
     * Retorna código do pedido.
     * @return Código do pedido.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna itens do pedido.
     * @return Itens do pedido.
     */
    public ArrayList<Tupla<Alimento, Integer>> getItens() {
        return itens;
    }

    /**
     * Adiciona novo item a lista de alimentos do pedido.
     * @param item Tupla contendo Alimento e quantidade.
     * @return Condição de sucesso.
     */
    public boolean adicionaItem(Tupla<Alimento, Integer> item) {
        if (item == null || item.getElemento1() == null || item.getElemento2() <= 0)
            return false;

        return itens.add(item);
    }

    /**
     * Calcula valor total dos itens do pedido.
     * @return Valor total.
     */
    public float calculaTotal() {
        float total = 0;

        if (!itens.isEmpty())
            for (Tupla<Alimento, Integer> item : itens)
                total += item.getElemento2() * item.getElemento1().getValor();

        return total;
    }

    /**
     * Formata pedido contendo informações de todos os itens adicionados na lista, código e valor total.
     * @return Pedido formatado.
     */
    public String exibePedido() {
        if (itens.isEmpty())
            return null;

        String linhaSeparadora = "+---------------------------------------------------------------------------+\n";
        String cabecalho = "| PRODUTO                                             VALOR     QUANTIDADE  |\n" ;

        StringBuilder pedido = new StringBuilder();
        pedido.append(linhaSeparadora).append(cabecalho).append(linhaSeparadora);

        for (Tupla<Alimento, Integer> item : itens)
            pedido.append(formataItemPedido(item.getElemento1(), item.getElemento2())).append("\n");

        pedido.append(linhaSeparadora);
        DecimalFormat formatter = new DecimalFormat("####0.00");
        pedido.append("   ===>>> CÓDIGO: ").append(codigo);
        pedido.append("\n   ===>>>  TOTAL: R$ ").append(formatter.format(calculaTotal()));

        return pedido.toString();
    }

    /**
     * Formata item do pedido.
     * @param alimento Alimento do item.
     * @param quantidade Quantidade do item.
     * @return Item formatado.
     */
    private String formataItemPedido(Alimento alimento, int quantidade) {
        String formatacao = "| %-50s  R$ %2.2f  %03d         |";
        if (alimento.getValor() < 10)
            formatacao = "| %-50s  R$  %1.2f  %03d         |";

        Formatter formatter = new Formatter();
        formatter.format(formatacao, alimento.getNome(), alimento.getValor(), quantidade);

        String item = formatter.toString();
        formatter.close();

        return item;
    }
}
