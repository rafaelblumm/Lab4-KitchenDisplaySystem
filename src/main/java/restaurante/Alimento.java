package restaurante;

import java.util.Formatter;

/**
 * Classe que representa um alimento do cardápio.
 */
public class Alimento {
    private final String nome;
    private final float valor;
    private final Categoria categoria;

    public Alimento(String nome, float valor, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    /**
     * Retorna o nome.
     * @return Nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o valor.
     * @return Valor.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Retorna a categoria.
     * @return Categoria.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Formata dados do alimento para padrão de listagem.
     * @return Dados formatados.
     */
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
