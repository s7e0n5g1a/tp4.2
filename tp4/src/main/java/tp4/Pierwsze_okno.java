package tp4;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

class Pierwsze_okno {

    Button przycisk1_ok =  new  Button();

    Pierwsze_okno(final Stage pierwsza_strona)  {
        VBox vbox1 = new VBox(8);
        Label ilosc_graczy = new Label("Wprowadź iczbę graczy:"); //napis
        final TextField ilosc_g = new TextField ();
        przycisk1_ok.setText("OK");
        vbox1.getChildren().addAll(ilosc_graczy,ilosc_g, przycisk1_ok);
        Scene scene1 = new Scene(vbox1, 500, 500);
        pierwsza_strona.setScene(scene1);
        pierwsza_strona.show();
        przycisk1_ok.setOnAction(
                event -> { // co robi przycisk ok
                    int g = Integer.parseInt(ilosc_g.getText());
                        Drugie_okno druga_scena =  new Drugie_okno(g);
                    pierwsza_strona.close();
                }
        );

    }

}