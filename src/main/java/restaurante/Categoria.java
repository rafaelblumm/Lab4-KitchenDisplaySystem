package restaurante;

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

    public String getDescricao() {
        return descricao;
    }
}
