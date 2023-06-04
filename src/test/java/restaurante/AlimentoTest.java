package restaurante;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlimentoTest {
    @Test
    @DisplayName("toListagem | valor > 10")
    public void toListagemMenorQue10 () {
        Alimento alimento = new Alimento("Pastel", 8, Categoria.VEGANO);

        String esperado = "Pastel                                              R$  8,00  Vegano     ";
        assertEquals(esperado, alimento.toListagem());
    }

    @Test
    @DisplayName("toListagem | valor = 10")
    public void toListagemIgual10 () {
        Alimento alimento = new Alimento("Cachorro quente", 10, Categoria.VEGETARIANO);

        String esperado = "Cachorro quente                                     R$ 10,00  Vegetariano";
        assertEquals(esperado, alimento.toListagem());
    }

    @Test
    @DisplayName("toListagem | valor > 10")
    public void toListagemMaiorQue10 () {
        Alimento alimento = new Alimento("Pizza", 30, Categoria.VEGETARIANO);

        String esperado = "Pizza                                               R$ 30,00  Vegetariano";
        assertEquals(esperado, alimento.toListagem());
    }
}
