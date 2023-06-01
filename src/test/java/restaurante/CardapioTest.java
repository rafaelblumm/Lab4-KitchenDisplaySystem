package restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardapioTest {
    private Cardapio cardapio;

    @BeforeEach
    public void inicializa() {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento("Pastel", 10, Categoria.VEGANO));
        alimentos.add(new Alimento("Pizza", 30, Categoria.VEGETARIANO));
        alimentos.add(new Alimento("Hamburguer", 20, Categoria.COM_CARNE));
        alimentos.add(new Alimento("Batatas fritas", 5, Categoria.APERITIVO));
        alimentos.add(new Alimento("Guarana", 4, Categoria.BEBIDA));

        cardapio = new Cardapio(alimentos);
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

        assertEquals(listagemEsperada, cardapio.listaItens());
    }

    @Test
    public void listaItensCardapioVazio() {
        Cardapio cardapioVazio = new Cardapio(new ArrayList<>());
        assertNull(cardapioVazio.listaItens());
    }
}
