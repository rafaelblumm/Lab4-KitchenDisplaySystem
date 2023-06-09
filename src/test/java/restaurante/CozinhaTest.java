package restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

        cozinha = new Cozinha(new Cardapio(alimentos));
    }

    @Test
    @DisplayName("adicionaPedido | válido")
    public void adicionaPedidoValido() {
        Pedido pedido = new Pedido(1085);
        pedido.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(1), 3));
        pedido.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(4), 5));

        assertTrue(cozinha.adicionaPedido(pedido));
    }

    @Test
    @DisplayName("adicionaPedido | null")
    public void adicionaPedidoNull() {
        assertFalse(cozinha.adicionaPedido(null));
    }

    @Test
    @DisplayName("adicionaPedido | vazio")
    public void adicionaPedidoVazio() {
        Pedido pedido = new Pedido(297);
        assertFalse(cozinha.adicionaPedido(pedido));
    }

    @Test
    @DisplayName("exibePrimeiroPedido | válido")
    public void exibePrimeiroPedidoValido() {
        Pedido pedido = new Pedido(1095);
        pedido.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(0), 8));

        cozinha.adicionaPedido(pedido);
        Pedido primeiroPedido = cozinha.exibePrimeiroPedido();

        assertEquals(pedido.getCodigo(), primeiroPedido.getCodigo());
        assertEquals(pedido.getItens(), primeiroPedido.getItens());
    }

    @Test
    @DisplayName("exibePrimeiroPedido | vazio")
    public void exibePrimeiroPedidoVazio() {
        assertNull(cozinha.exibePrimeiroPedido());
    }


    @Test
    @DisplayName("entregaPedido | válido")
    public void entregaPedidoValido() {
        Pedido pedido1 = new Pedido(285);
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(2), 1));
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(0), 2));

        Pedido pedido2 = new Pedido(286);
        pedido2.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(1), 3));

        cozinha.adicionaPedido(pedido1);
        cozinha.adicionaPedido(pedido2);
        Pedido primeiroPedido = cozinha.entregaPedido();

        assertEquals(pedido1.getCodigo(), primeiroPedido.getCodigo());
        assertEquals(pedido1.getItens(), primeiroPedido.getItens());

        assertNotEquals(pedido1.getCodigo(), cozinha.getPedidos().peek().getCodigo());
        assertNotEquals(pedido1.getItens(), cozinha.getPedidos().peek().getItens());
    }

    @Test
    @DisplayName("entregaPedido | vazio")
    public void entregaPedidoNull() {
        assertNull(cozinha.entregaPedido());
    }

    @Test
    @DisplayName("listaPedidos | válido")
    public void listaPedidosValido() {
        Pedido pedido1 = new Pedido(285);
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(2), 1));
        pedido1.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(0), 2));

        Pedido pedido2 = new Pedido(286);
        pedido2.adicionaItem(new Tupla<>(cozinha.getCardapio().getItens().get(1), 3));

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
    @DisplayName("listaPedidos | vazio")
    public void listaPedidosVazio() {
        assertNull(cozinha.listaPedidos());
    }
}
