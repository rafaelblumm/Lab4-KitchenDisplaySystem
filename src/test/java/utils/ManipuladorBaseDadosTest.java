package utils;

import exceptions.CardapioVazioException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import restaurante.Alimento;
import restaurante.Categoria;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ManipuladorBaseDadosTest {
    private static String dirResources;
    private ManipuladorBaseDados bd;

    @BeforeAll
    public static void setUp() {
        dirResources = System.getProperty("user.dir") + "\\src\\test\\resources\\";
    }

    @Test
    public void leCardapioValido() throws CardapioVazioException {
        bd = new ManipuladorBaseDados("cardapio_valido.csv", dirResources);
        ArrayList<Alimento> alimentos = bd.leCardapio();

        Alimento a0 = new Alimento("Pastel", 10, Categoria.VEGANO);
        Alimento a1 = new Alimento("Pizza", 30, Categoria.VEGETARIANO);
        Alimento a2 = new Alimento("Hamburguer", 20, Categoria.COM_CARNE);
        Alimento a3 = new Alimento("Batatas fritas", 5, Categoria.APERITIVO);
        Alimento a4 = new Alimento("Guarana", 4, Categoria.BEBIDA);

        assertEquals(a0, alimentos.get(0));
        assertEquals(a1, alimentos.get(1));
        assertEquals(a2, alimentos.get(2));
        assertEquals(a3, alimentos.get(3));
        assertEquals(a4, alimentos.get(4));
    }

    @Test
    public void leCardapioVazio() throws CardapioVazioException {
        bd = new ManipuladorBaseDados("cardapio_vazio.csv", dirResources);
        assertThrows(CardapioVazioException.class, () -> bd.leCardapio());
    }

    @Test
    public void leCardapioInexistente() throws CardapioVazioException {
        bd = new ManipuladorBaseDados("cardapio_inexistente.csv", dirResources);
        assertNull(bd.leCardapio());
    }
}
