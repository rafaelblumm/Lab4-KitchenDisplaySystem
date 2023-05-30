package restaurante;

import utils.Tupla;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;

public class Pedido {
    private int codigo;
    private ArrayList<Tupla<Alimento, Integer>> itens;

    public Pedido(int codigo) {
        this.codigo = codigo;
        this.itens = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Tupla<Alimento, Integer>> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Tupla<Alimento, Integer>> itens) {
        this.itens = itens;
    }

    public boolean adicionaItem(Tupla<Alimento, Integer> item) {
        if (item == null || item.getElemento1() == null || item.getElemento2() <= 0)
            return false;

        return itens.add(item);
    }

    public float calculaTotal() {
        float total = 0;

        if (!itens.isEmpty())
            for (Tupla<Alimento, Integer> item : itens)
                total += item.getElemento2() * item.getElemento1().getValor();

        return total;
    }

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
