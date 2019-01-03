package  tp4;

import javafx.application.Application;
import javafx.stage.Stage;
//fsdfsd
public class Main extends Application {

    public void start(final Stage pierwszastrona)  {
        pierwszastrona.setTitle("Chinese Checkers");
        Buttoner przycisk1_ok = new Buttoner(pierwszastrona);
    }
    public static void main(String[] args) {
        launch(args);
    }

}