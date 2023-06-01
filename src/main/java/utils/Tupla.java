package utils;

/**
 * Classe que implementa registro de um par de elementos genéricos e imutáveis.
 * @param <E1> Elemento 1.
 * @param <E2> Elemento 2.
 */
public class Tupla<E1, E2>{
    private final E1 elemento1;
    private final E2 elemento2;

    public Tupla(E1 elemento1, E2 elemento2) {
        this.elemento1 = elemento1;
        this.elemento2 = elemento2;
    }

    /**
     * Recupera primeiro elemento do par.
     * @return Elemento 1.
     */
    public E1 getElemento1() {
        return elemento1;
    }

    /**
     * Recupera segundo elemento do par.
     * @return Elemento 2.
     */
    public E2 getElemento2() {
        return elemento2;
    }

    @Override
    public String toString() {
        return "(" + elemento1 + ", " + elemento2 + ")";
    }
}
