package restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Tupla;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CozinhaTest {
    private Cozinha cozinha;

    @BeforeEach
    public void inicializa() {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento("Pastel", 10, Categoria.VEGANO));
        alimentos.add(new Alimento("Pizza", 30, Categoria.VEGETARIANO));
        alimentos.add(new Alimento("Hamburguer", 20, Categoria.COM_CARNE));
        alimentos.add(new Alimento("Batatas fritas", 5, Categoria.APERITIVO));
        alimentos.add(new Alimento("Guarana", 4, Categoria.BEBIDA));

        cozinha = new Cozinha(alimentos);
    }

    @Test
    public void adicionaPedidoValido() {
        Pedido pedido = new Pedido(1085);
        pedido.adicionaItem(new Tupla<>(cozinha.getCardapio().get(1), 3));
        pedido.adicionaItem(new Tupla<>(cozinha.getCardapio().get(4), 5));

        assertTrue(cozinha.adicionaPedido(pedido));
    }

    @Test
    public void adicionaPedidoNull() {
        assertFalse(cozinha.adicionaPedido(null));
    }

    @Test
    public void adicionaPedidoVazio() {
        Pedido pedido = new Pedido(297);
        assertFalse(cozinha.adicionaPedido(pedido));
    }

    @Test
    public void exibePrimeiroPedidoValido() {
        Pedido pedido = new Pedido(1095);
        pedido.adicionaItem(new Tupla<>(cozinha.getCardapio().get(0), 8));

        cozinha.adicionaPedido(pedido);
        Pedido primeiroPedido = cozinha.exibePrimeiroPedido();

        assertEquals(pedido.getCodigo(), primeiroPedido.getCodigo());
        assertEquals(pedido.getItens(), primeiroPedido.getItens());
    }

    @Test
    public void exibePrimeiroPedidoVazio() {
        assertNull(cozinha.exibePrimeiroPedido());
    }


    @Test
    public void entregaPedidoValido() {
        Pedido pedido1 = new Pedido(285);
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().get(2), 1));
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().get(0), 2));

        Pedido pedido2 = new Pedido(286);
        pedido2.adicionaItem(new Tupla<>(cozinha.getCardapio().get(1), 3));

        cozinha.adicionaPedido(pedido1);
        cozinha.adicionaPedido(pedido2);
        Pedido primeiroPedido = cozinha.entregaPedido();

        assertEquals(pedido1.getCodigo(), primeiroPedido.getCodigo());
        assertEquals(pedido1.getItens(), primeiroPedido.getItens());

        assertNotEquals(pedido1.getCodigo(), cozinha.getPedidos().peek().getCodigo());
        assertNotEquals(pedido1.getItens(), cozinha.getPedidos().peek().getItens());
    }

    @Test
    public void entregaPedidoNull() {
        assertNull(cozinha.entregaPedido());
    }

    @Test
    public void listaPedidosValido() {
        Pedido pedido1 = new Pedido(285);
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().get(2), 1));
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().get(0), 2));

        Pedido pedido2 = new Pedido(286);
        pedido2.adicionaItem(new Tupla<>(cozinha.getCardapio().get(1), 3));

        cozinha.adicionaPedido(pedido1);
        cozinha.adicionaPedido(pedido2);

        String listagemEsperada = "+---------------------------------------------------------------------------+\n" +
                                  "|                            P  E  D  I  D  O  S                            |\n" +
                                  "+---------------------------------------------------------------------------+\n\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "| PRODUTO                                             VALOR     QUANTIDADE  |\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "| Hamburguer                                          R$ 20,00  001         |\n" +
                                  "| Pastel                                              R$ 10,00  002         |\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "   ===>>> CÓDIGO: 285" +
                                  "\n   ===>>>  TOTAL: R$ 40,00\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "| PRODUTO                                             VALOR     QUANTIDADE  |\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "| Pizza                                               R$ 30,00  003         |\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "   ===>>> CÓDIGO: 286" +
                                  "\n   ===>>>  TOTAL: R$ 90,00\n";

        assertEquals(listagemEsperada, cozinha.listaPedidos());
    }

    @Test
    public void listaPedidosVazio() {
        assertNull(cozinha.listaPedidos());
    }

    @Test
    public void listaItensCardapioPreenchido() {
        String listagemEsperada = "+-------------------------------------------------------------------------------+\n" +
                                  "|                             C  A  R  D  A  P  I  O                            |\n" +
                                  "+-------------------------------------------------------------------------------+\n" +
                                  "| ID  PRODUTO                                             VALOR     CATEGORIA   |\n" +
                                  "+-------------------------------------------------------------------------------+\n" +
                                  "|  1  Pastel                                              R$ 10,00  Vegano      |\n" +
                                  "|  2  Pizza                                               R$ 30,00  Vegetariano |\n" +
                                  "|  3  Hamburguer                                          R$ 20,00  Com carne   |\n" +
                                  "|  4  Batatas fritas                                      R$  5,00  Aperitivo   |\n" +
                                  "|  5  Guarana                                             R$  4,00  Bebida      |\n" +
                                  "+-------------------------------------------------------------------------------+\n";

        assertEquals(listagemEsperada, cozinha.listaItensCardapio());
    }

    @Test
    public void listaItensCardapioVazio() {
        Cozinha cozinhaVazia = new Cozinha(new ArrayList<>());
        assertNull(cozinhaVazia.listaItensCardapio());
    }
}
