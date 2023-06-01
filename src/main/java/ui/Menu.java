package ui;

import restaurante.Alimento;
import restaurante.Cardapio;
import restaurante.Pedido;

/**
 * Classe que recebe e exibe informações na tela para o usuário.
 */
public class Menu {
    /**
     * Exibe título inicial do programa.
     */
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

    /**
     * Exibe opções de operações a serem realizadas no programa.
     */
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

    /**
     * Loop de aceitação do código da operação a ser realizada.
     * @return Código da operação.
     */
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

    /**
     * Exibe fila de pedidos.
     * @param fila Listagem da fila de pedidos.
     */
    public void exibeFila(String fila) {
        if (fila != null)
            System.out.println(fila);
        else
            Msg.exibeErro("Nenhum pedido registrado");
    }

    /**
     * Loop de aceitação do código do produto escolhido pelo usuário.
     * @param cardapio Cardápio com alimentos a serem escolhidos.
     * @return Alimento escolhido.
     */
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

    /**
     * Loop de aceitação da quantidade do alimento escolhido pelo usuário.
     * @return Quantidade escolhida.
     */
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

    /**
     * Exibe pedido que foi entregue.
     * @param pedido Pedido que foi entregue.
     */
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

    /**
     * Exibe mensagem de encerramento do programa.
     */
    public void sair() {
        System.out.println("Encerrando aplicativo.");
    }
}
