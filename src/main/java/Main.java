import exceptions.CardapioVazioException;
import ui.Controller;
import ui.Msg;

public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();

        try {
            ctrl.inicializa();
        } catch (CardapioVazioException e) {
            Msg.exibeErro(e.getMessage() + "\n     Encerrando aplicativo.");
            System.exit(0);
        }

        ctrl.start();
    }
}
