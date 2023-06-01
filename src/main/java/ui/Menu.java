package ui;

import restaurante.Alimento;
import restaurante.Cardapio;
import restaurante.Pedido;

public class Menu {
    public void exibeTitulo() {
        String titulo = """
                                                             __                        \s
                                                           /                          \s
                                                        .-/-.                         \s
                ___  ___     _____ _                    |'-'|                         \s
                |  \\/  |    /  ___(_)                   |   |                         \s
                | .  . | ___\\ `--. _ _ __   ___  ___    |   |   .-""\""-.              \s
                | |\\/| |/ __|`--. \\ | '_ \\ / _ \\/ __|   \\___/  /' .  '. \\   \\|/\\//    \s
                | |  | | (__/\\__/ / | | | | (_) \\__ \\         (`-..:...-')  |`""`|    \s
                \\_|  |_/\\___\\____/|_|_| |_|\\___/|___/          ;-......-;   |    |    \s
                                                                '------'    \\____/    \s
                """;
        System.out.println(titulo);
    }

    public void exibeOperacoes() {
        String operacoes = """
                
                +-----------------------------+
                |        M   E   N   U        |
                +-----------------------------+
                |  1. Exibir fila de pedidos  |
                |  2. Solicitar pedido        |
                |  3. Entregar pedido         |
                |  4. Sair                    |
                +-----------------------------+
                """;

        System.out.println(operacoes);
    }

    public int aceitaOperacao() {
        int op;

        while (true) {
            op = Teclado.leInt("Digite a operação desejada: ");

            if (op > 0 && op < 5)
                break;

            Msg.exibeErro("Operação inválida");
        }

        return op;
    }

    public void exibeFila(String fila) {
        if (fila != null)
            System.out.println(fila);
        else
            Msg.exibeErro("Nenhum pedido registrado");
    }

    public Alimento aceitaAlimento(Cardapio cardapio) {
        int op;

        while (true) {
            System.out.println(cardapio.listaItens());
            op = Teclado.leInt("Digite o id do alimento desejado ou 0 para sair: ");

            if (op >= 0 && op <= cardapio.getItens().size())
                break;
            Msg.exibeErro("Opção inválida");
        }

        return op == 0 ? null : cardapio.getItens().get(op - 1);
    }

    public int aceitaQuantidade() {
        int qnt;

        while (true) {
            qnt = Teclado.leInt("Digite a quantidade desejada: ");

            if (qnt > 0 && qnt < Pedido.MAX_QUANTIDADE)
                break;
            Msg.exibeErro("Quantidade inválida");
        }

        return qnt;
    }

    public void exibeEntregaPedido(Pedido pedido) {
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

    public void sair() {
        System.out.println("Encerrando aplicativo.");
    }
}
