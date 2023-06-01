package ui;

import exceptions.CardapioVazioException;
import restaurante.Alimento;
import restaurante.Cardapio;
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

        try {
            cozinha = new Cozinha(new Cardapio(bd.leCardapio()));
            return true;
        } catch (CardapioVazioException e) {
            Msg.exibeErro(e.getMessage() + "\n     Encerrando aplicativo.");
            return false;
        }
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

    private void solicitaPedido() {
        if (cozinha.adicionaPedido(aceitaPedido()))
            Msg.exibeSucesso("Pedido #" + codigoAtual + " registrado");
        else
            Msg.exibeErro("Falha ao registrar pedido #" + codigoAtual--);
    }

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
