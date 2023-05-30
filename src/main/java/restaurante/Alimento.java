package restaurante;

import java.util.Formatter;

public class Alimento {
    private String nome;
    private float valor;
    private Categoria categoria;

    public Alimento(String nome, float valor, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String toListagem() {
        String formatacao = valor < 10 ? "%-50s  R$  %1.2f  %-11s" : "%-50s  R$ %2.2f  %-11s";

        Formatter formatter = new Formatter();
        formatter.format(formatacao, nome, valor, categoria.getDescricao());

        String listagem = formatter.toString();
        formatter.close();

        return listagem;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nValor: R$" + valor +
                "\nCategoria: " + categoria.getDescricao();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == getClass() && obj.toString().equals(toString());
    }
}
