package ui;

import restaurante.Alimento;
import restaurante.Cozinha;
import restaurante.Pedido;
import utils.ManipuladorBaseDados;
import utils.Tupla;

import java.util.ArrayList;

public class Controller {
    private static final int OP_EXIBE_FILA = 1;
    private static final int OP_SOLICITA_PEDIDO = 2;
    private static final int OP_ENTREGA_PEDIDO = 3;
    private static final int OP_SAIR = 4;

    private final Menu menu;
    private Cozinha cozinha;
    private int codigoAtual;

    public Controller() {
        this.menu = new Menu();
        this.codigoAtual = 0;
    }

    public boolean inicializa() {
        ManipuladorBaseDados bd = new ManipuladorBaseDados("cardapio.csv");
        ArrayList<Alimento> cardapio = bd.leCardapio();

        if (cardapio != null && !cardapio.isEmpty()) {
            cozinha = new Cozinha(cardapio);
            return true;
        }

        Msg.exibeErro("Não foi possível ler registro de alimentos do cardápio." +
                "\n     Encerrando aplicativo.");
        return false;
    }

    public void start() {
        menu.exibeTitulo();
        int op = 0;

        while (op != OP_SAIR) {
            menu.exibeOperacoes();
            op = menu.aceitaOperacao();
            executaOperacao(op);
        }
    }

    private void executaOperacao(int op) {
        switch (op) {
            case OP_EXIBE_FILA -> exibeFila();
            case OP_SOLICITA_PEDIDO -> solicitaPedido();
            case OP_ENTREGA_PEDIDO -> entregaPedido();
            case OP_SAIR -> System.out.println("Encerrando aplicativo.");
        }
    }

    private void exibeFila() {
        String fila = cozinha.listaPedidos();
        if (fila != null)
            System.out.println(fila);
        else
            Msg.exibeErro("Nenhum pedido registrado");
    }

    private void solicitaPedido() {
        if (cozinha.adicionaPedido(aceitaPedido()))
            Msg.exibeSucesso("Pedido #" + codigoAtual + " registrado");
        else
            Msg.exibeErro("Falha ao registrar pedido #" + codigoAtual--);
    }

    private Pedido aceitaPedido() {
        Pedido pedido = new Pedido(++codigoAtual);

        boolean adicionouItem;
        do
            adicionouItem = pedido.adicionaItem(aceitaAlimento());
        while (adicionouItem);

        return pedido;
    }

    private Tupla<Alimento, Integer> aceitaAlimento() {
        System.out.println(cozinha.listaItensCardapio());

        int op;
        while (true) {
            op = Teclado.leInt("Digite o id do alimento desejado ou 0 para sair: ");

            if (op >= 0 && op <= cozinha.getCardapio().size())
                break;
            Msg.exibeErro("Opção inválida");
        }

        if (op == 0)
            return null;

        int qnt;
        while (true) {
            qnt = Teclado.leInt("Digite a quantidade desejada: ");

            if (qnt > 0 && qnt < 100)
                break;
            Msg.exibeErro("Quantidade inválida");
        }

        return new Tupla<>(cozinha.getCardapio().get(op - 1), qnt);
    }

    private void entregaPedido() {
        Pedido pedido = cozinha.entregaPedido();
        if (pedido != null) {
            String titulo = """
                        +---------------------------------------------------------------------------+
                        |             E  N  T  R  E  G  A     D  E     P  E  D  I  D  O             |
                        """;
            System.out.println(titulo + pedido.exibePedido() + "\n");

            Msg.exibeSucesso("Pedido entregue com sucesso");
        } else
            Msg.exibeErro("Nenhum pedido registrado");
    }
}
