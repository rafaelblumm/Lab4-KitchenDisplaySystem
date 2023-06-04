package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.Alimento;
import restaurante.Categoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TuplaTest {
    @Test
    @DisplayName("getElemento1 | String")
    public void getElemento1String() {
        Tupla<String, Integer> tupla = new Tupla<>("Pastel", 5);

        assertEquals("Pastel", tupla.getElemento1());
    }

    @Test
    @DisplayName("getElemento1 | Integer")
    public void getElemento1Integer() {
        Tupla<Integer, String> tupla = new Tupla<>(5, "Pastel");

        assertEquals(5, tupla.getElemento1());
    }

    @Test
    @DisplayName("getElemento1 | Alimento")
    public void getElemento1Alimento() {
        Alimento alimento = new Alimento("Pastel", 15, Categoria.VEGETARIANO);
        Tupla<Alimento, Integer> tupla = new Tupla<>(alimento, 5);

        assertEquals(alimento, tupla.getElemento1());
    }

    @Test
    @DisplayName("getElemento2 | String")
    public void getElemento2String() {
        Tupla<Integer, String> tupla = new Tupla<>(5, "Pastel");

        assertEquals("Pastel", tupla.getElemento2());
    }

    @Test
    @DisplayName("getElemento2 | Integer")
    public void getElemento2Integer() {
        Tupla<String, Integer> tupla = new Tupla<>("Pastel", 5);

        assertEquals(5, tupla.getElemento2());
    }

    @Test
    @DisplayName("getElemento2 | Alimento")
    public void getElemento2Alimento() {
        Alimento alimento = new Alimento("Pastel", 15, Categoria.VEGETARIANO);
        Tupla<Integer, Alimento> tupla = new Tupla<>(5, alimento);

        assertEquals(alimento, tupla.getElemento2());
    }

    @Test
    @DisplayName("toString | <Integer, Integer>")
    public void toStringIntegerInteger() {
        Tupla<Integer, Integer> tupla = new Tupla<>(10, 5);

        String esperado = "(10, 5)";
        assertEquals(esperado, tupla.toString());
    }

    @Test
    @DisplayName("toString | <String, String>")
    public void toStringStringString() {
        Tupla<String, String> tupla = new Tupla<>("Lasanha", "Garfield");

        String esperado = "(Lasanha, Garfield)";
        assertEquals(esperado, tupla.toString());
    }

    @Test
    @DisplayName("toString | <Alimento, Integer>")
    public void toStringAlimentoInteger() {
        Alimento alimento = new Alimento("Pastel", 15, Categoria.VEGETARIANO);
        Tupla<Alimento, Integer> tupla = new Tupla<>(alimento, 3);

        String esperado = "(Nome: Pastel\n" +
                          "Valor: R$15.0\n" +
                          "Categoria: Vegetariano, 3)";

        assertEquals(esperado, tupla.toString());
    }
}
