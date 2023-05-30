package ui;

public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();

        if (ctrl.inicializa())
            ctrl.start();
    }
}


