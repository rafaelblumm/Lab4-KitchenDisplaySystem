package exceptions;

/**
 * Sinaliza que o cardápio informado tem registro vazio.
 */
public class CardapioVazioException extends Throwable {
    public CardapioVazioException(String mensagem) {
        super(mensagem);
    }
}
