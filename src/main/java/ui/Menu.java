package ui;

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
}
