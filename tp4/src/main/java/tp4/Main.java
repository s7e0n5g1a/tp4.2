package tp4;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(final Stage pierwszastrona)  {

        pierwszastrona.setTitle("Chinese Checkers");
        Pierwsze_okno pierwsza_strona = new Pierwsze_okno(pierwszastrona);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
