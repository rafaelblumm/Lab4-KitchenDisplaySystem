package restaurante;

/**
 * Classe que representa categorias ocupadas pelos itens do cardápio do restaurante.
 */
public enum Categoria {
    VEGANO("Vegano"),
    VEGETARIANO("Vegetariano"),
    COM_CARNE("Com carne"),
    APERITIVO("Aperitivo"),
    BEBIDA("Bebida");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição.
     * @return Descrição.
     */
    public String getDescricao() {
        return descricao;
    }
}
