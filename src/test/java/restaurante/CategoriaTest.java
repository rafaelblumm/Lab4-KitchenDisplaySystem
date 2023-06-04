package restaurante;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaTest {
    @Test
    @DisplayName("getDescricao | VEGANO")
    public void getDescricaoVegano() {
        assertEquals("Vegano", Categoria.VEGANO.getDescricao());
    }

    @Test
    @DisplayName("getDescricao | VEGETARIANO")
    public void getDescricaoVegetariano() {
        assertEquals("Vegetariano", Categoria.VEGETARIANO.getDescricao());
    }

    @Test
    @DisplayName("getDescricao | COM_CARNE")
    public void getDescricaoComCarne() {
        assertEquals("Com carne", Categoria.COM_CARNE.getDescricao());
    }

    @Test
    @DisplayName("getDescricao | APERITIVO")
    public void getDescricaoAperitivo() {
        assertEquals("Aperitivo", Categoria.APERITIVO.getDescricao());
    }

    @Test
    @DisplayName("getDescricao | BEBIDA")
    public void getDescricaoBebida() {
        assertEquals("Bebida", Categoria.BEBIDA.getDescricao());
    }
}
