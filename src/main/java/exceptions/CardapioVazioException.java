package exceptions;

/**
 * Sinaliza que o cardápio informado tem registro vazio.
 */
public class CardapioVazioException extends Throwable {
    private final String mensagem;

    public CardapioVazioException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
