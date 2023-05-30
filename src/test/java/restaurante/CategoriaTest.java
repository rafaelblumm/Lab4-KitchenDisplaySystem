package restaurante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaTest {
    @Test
    public void getDescricaoVegano() {
        assertEquals("Vegano", Categoria.VEGANO.getDescricao());
    }

    @Test
    public void getDescricaoVegetariano() {
        assertEquals("Vegetariano", Categoria.VEGETARIANO.getDescricao());
    }

    @Test
    public void getDescricaoComCarne() {
        assertEquals("Com carne", Categoria.COM_CARNE.getDescricao());
    }

    @Test
    public void getDescricaoAperitivo() {
        assertEquals("Aperitivo", Categoria.APERITIVO.getDescricao());
    }

    @Test
    public void getDescricaoBebida() {
        assertEquals("Bebida", Categoria.BEBIDA.getDescricao());
    }
}
