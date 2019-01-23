package Klient;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Drugie_okno {

    String nazwa;

    public Drugie_okno() throws IOException, InterruptedException {
        Gwiazda g = new Gwiazda();
        VBox vbox1 = new VBox(8);
        Button przycisk_ok =  new  Button();
        Label l = new Label("Wprowadź nazwę gracza:"); //napis
        final TextField n = new TextField ();
        przycisk_ok.setText("OK");
        vbox1.getChildren().addAll(l, n, przycisk_ok);
        Scene druga_scena = new Scene(vbox1, 500, 500);
        Stage druga_strona = new Stage(); //New window (Stage)
        druga_strona.setScene(druga_scena);
        druga_strona.show();

        przycisk_ok.setOnAction(
                event -> {
                    try {
                        druga_strona.close();
                        //Gwiazda g = new Gwiazda();
                        Klienci.go(n.getText(), g);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
