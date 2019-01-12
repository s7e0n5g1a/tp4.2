package  tp4;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(final Stage pierwszastrona)  {
        pierwszastrona.setTitle("Chinese Checkers");
        Pierwsze_okno pierwsza_strona = new Pierwsze_okno(pierwszastrona);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Serwer otworz_serwer = new Serwer();
        launch(args);

    }

}