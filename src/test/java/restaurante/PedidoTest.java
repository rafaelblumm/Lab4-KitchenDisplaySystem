package restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Tupla;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    public void inicializa() {
        pedido = new Pedido(2235);
    }

    @Test
    public void adicionaItemValido() {
        Alimento alimento = new Alimento("Polenta frita", 10, Categoria.APERITIVO);
        assertTrue(pedido.adicionaItem(new Tupla<>(alimento, 5)));
    }

    @Test
    public void adicionaItemNull() {
        assertFalse(pedido.adicionaItem(null));
    }

    @Test
    public void adicionaItemQuantidadeZero() {
        Alimento alimento = new Alimento("Polenta frita", 10, Categoria.APERITIVO);
        assertFalse(pedido.adicionaItem(new Tupla<>(alimento, 0)));
    }

    @Test
    public void adicionaItemQuantidadeMenorQueZero() {
        Alimento alimento = new Alimento("Polenta frita", 10, Categoria.APERITIVO);
        assertFalse(pedido.adicionaItem(new Tupla<>(alimento, -8)));
    }

    @Test
    public void calculaTotalItensValidos() {
        pedido.adicionaItem(new Tupla<>(new Alimento("Pastel", 10, Categoria.VEGANO), 3));
        pedido.adicionaItem(new Tupla<>(new Alimento("Pizza", 30, Categoria.VEGETARIANO), 2));
        pedido.adicionaItem(new Tupla<>(new Alimento("Hamburguer", 20, Categoria.COM_CARNE), 1));
        pedido.adicionaItem(new Tupla<>(new Alimento("Batatas fritas", 5, Categoria.APERITIVO), 6));
        pedido.adicionaItem(new Tupla<>(new Alimento("Guarana", 4, Categoria.BEBIDA), 10));

        assertEquals(180, pedido.calculaTotal());
    }

    @Test
    public void calculaTotalVazio() {
        assertEquals(0, pedido.calculaTotal());
    }

    @Test
    public void exibePedidoValido() {
        pedido.adicionaItem(new Tupla<>(new Alimento("Pastel", 10, Categoria.VEGANO), 3));
        pedido.adicionaItem(new Tupla<>(new Alimento("Pizza", 30, Categoria.VEGETARIANO), 2));
        pedido.adicionaItem(new Tupla<>(new Alimento("Hamburguer", 20, Categoria.COM_CARNE), 1));
        pedido.adicionaItem(new Tupla<>(new Alimento("Batatas fritas", 5, Categoria.APERITIVO), 6));
        pedido.adicionaItem(new Tupla<>(new Alimento("Guarana", 4, Categoria.BEBIDA), 10));

        String listagemEsperada = "+---------------------------------------------------------------------------+\n" +
                                  "| PRODUTO                                             VALOR     QUANTIDADE  |\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "| Pastel                                              R$ 10,00  003         |\n" +
                                  "| Pizza                                               R$ 30,00  002         |\n" +
                                  "| Hamburguer                                          R$ 20,00  001         |\n" +
                                  "| Batatas fritas                                      R$  5,00  006         |\n" +
                                  "| Guarana                                             R$  4,00  010         |\n" +
                                  "+---------------------------------------------------------------------------+\n" +
                                  "   ===>>> CÓDIGO: 2235" +
                                  "\n   ===>>>  TOTAL: R$ 180,00";

        assertEquals(listagemEsperada, pedido.exibePedido());
    }

    @Test
    public void exibePedidoVazio() {
        assertNull(pedido.exibePedido());
    }
}
