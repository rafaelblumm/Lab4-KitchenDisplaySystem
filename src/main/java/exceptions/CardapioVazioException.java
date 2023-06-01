package exceptions;

public class CardapioVazioException extends Throwable {
    private String mensagem;
    public CardapioVazioException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
