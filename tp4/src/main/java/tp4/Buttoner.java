package tp4;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

class Buttoner {

    Button przycisk1_ok =  new  Button();

    Buttoner(final Stage primaryStage)  {

        VBox vbox1 = new VBox(8);
        Label ilosc_graczy = new Label("Wprowadź ilość graczy:"); //napis
        final TextField ilosc_g = new TextField ();
        przycisk1_ok.setText("OK");
        vbox1.getChildren().addAll(ilosc_graczy,ilosc_g, przycisk1_ok);
        Scene scene1 = new Scene(vbox1, 500, 500);
        primaryStage.setScene(scene1);
        primaryStage.show();
        przycisk1_ok.setOnAction(
                event -> { // co robi przycisk ok
                    try {
                        SecondScene secondscene =  new SecondScene(ilosc_g.getText());
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    primaryStage.close();
                }
        );

    }

}