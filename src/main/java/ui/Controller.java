package ui;

import exceptions.CardapioVazioException;
import restaurante.Alimento;
import restaurante.Cardapio;
import restaurante.Cozinha;
import restaurante.Pedido;
import utils.ManipuladorBaseDados;
import utils.Tupla;

/**
 * Classe que permite controle do fluxo do programa.
 */
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

    /**
     * Realiza procedimentos necessários para inicialização do programa.
     */
    public void inicializa() throws CardapioVazioException {
        ManipuladorBaseDados bd = new ManipuladorBaseDados("McSinos-cardapio.csv");
        cozinha = new Cozinha(new Cardapio(bd.leCardapio()));
    }

    /**
     * Inicia o programa. Controla o fluxo principal de interações.
     */
    public void start() {
        menu.exibeTitulo();
        int op;

        do {
            menu.exibeOperacoes();
            op = menu.aceitaOperacao();
            executaOperacao(op);
        } while (op != OP_SAIR);
    }

    /**
     * Executa operação indicada pelo usuário.
     * @param op Código da operação.
     */
    private void executaOperacao(int op) {
        switch (op) {
            case OP_EXIBE_FILA ->
                    menu.exibeFila(cozinha.listaPedidos());
            case OP_SOLICITA_PEDIDO ->
                    solicitaPedido();
            case OP_ENTREGA_PEDIDO ->
                    menu.exibeEntregaPedido(cozinha.entregaPedido());
            case OP_SAIR ->
                    menu.sair();
        }
    }

    /**
     * Registra pedido do usuário.
     */
    private void solicitaPedido() {
        if (cozinha.adicionaPedido(aceitaPedido()))
            Msg.exibeSucesso("Pedido #" + codigoAtual + " registrado");
        else
            Msg.exibeErro("Falha ao registrar pedido #" + codigoAtual--);
    }

    /**
     * Loop de aceitação do pedido do usuário.
     * @return Pedido gerado.
     */
    private Pedido aceitaPedido() {
        Pedido pedido = new Pedido(++codigoAtual);

        boolean adicionouItem;
        do {
            Alimento alimento = menu.aceitaAlimento(cozinha.getCardapio());
            if (alimento == null)
                break;

            adicionouItem = pedido.adicionaItem(new Tupla<>(alimento, menu.aceitaQuantidade()));
        } while (adicionouItem);

        return pedido;
    }
}
