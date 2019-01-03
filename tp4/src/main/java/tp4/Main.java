package  tp4;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(final Stage pierwszastrona)  {
        pierwszastrona.setTitle("Chinese Checkers");
        Buttoner przycisk1_ok = new Buttoner(pierwszastrona);
    }
    public static void main(String[] args) {
        launch(args);
        Klasa_serwera server=new Klasa_serwera();
        try {
            server.zacznij(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}