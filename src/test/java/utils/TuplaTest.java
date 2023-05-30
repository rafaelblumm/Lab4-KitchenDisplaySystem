package utils;

import restaurante.Alimento;
import restaurante.Categoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TuplaTest {
    @Test
    public void getElemento1String() {
        Tupla<String, Integer> tupla = new Tupla<>("Pastel", 5);

        assertEquals("Pastel", tupla.getElemento1());
    }

    @Test
    public void getElemento1Integer() {
        Tupla<Integer, String> tupla = new Tupla<>(5, "Pastel");

        assertEquals(5, tupla.getElemento1());
    }

    @Test
    public void getElemento1Alimento() {
        Alimento alimento = new Alimento("Pastel", 15, Categoria.VEGETARIANO);
        Tupla<Alimento, Integer> tupla = new Tupla<>(alimento, 5);

        assertEquals(alimento, tupla.getElemento1());
    }

    @Test
    public void getElemento2String() {
        Tupla<Integer, String> tupla = new Tupla<>(5, "Pastel");

        assertEquals("Pastel", tupla.getElemento2());
    }

    @Test
    public void getElemento2Integer() {
        Tupla<String, Integer> tupla = new Tupla<>("Pastel", 5);

        assertEquals(5, tupla.getElemento2());
    }

    @Test
    public void getElemento2Alimento() {
        Alimento alimento = new Alimento("Pastel", 15, Categoria.VEGETARIANO);
        Tupla<Integer, Alimento> tupla = new Tupla<>(5, alimento);

        assertEquals(alimento, tupla.getElemento2());
    }

    @Test
    public void toStringIntegerInteger() {
        Tupla<Integer, Integer> tupla = new Tupla<>(10, 5);

        String esperado = "(10, 5)";
        assertEquals(esperado, tupla.toString());
    }

    @Test
    public void toStringStringString() {
        Tupla<String, String> tupla = new Tupla<>("Lasanha", "Garfield");

        String esperado = "(Lasanha, Garfield)";
        assertEquals(esperado, tupla.toString());
    }

    @Test
    public void toStringAlimentoInteger() {
        Alimento alimento = new Alimento("Pastel", 15, Categoria.VEGETARIANO);
        Tupla<Alimento, Integer> tupla = new Tupla<>(alimento, 3);

        String esperado = "(Nome: Pastel\n" +
                          "Valor: R$15.0\n" +
                          "Categoria: Vegetariano, 3)";

        assertEquals(esperado, tupla.toString());
    }
}
