package utils;

public class Tupla<E1, E2>{
    private final E1 elemento1;
    private final E2 elemento2;

    public Tupla(E1 elemento1, E2 elemento2) {
        this.elemento1 = elemento1;
        this.elemento2 = elemento2;
    }

    public E1 getElemento1() {
        return elemento1;
    }

    public E2 getElemento2() {
        return elemento2;
    }

    @Override
    public String toString() {
        return "(" + elemento1 + ", " + elemento2 + ")";
    }
}
