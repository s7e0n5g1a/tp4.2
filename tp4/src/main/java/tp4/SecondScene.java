package tp4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class SecondScene {
    String []tablica_nazw =  new String [6];
    VBox vbox2 = new VBox(8);
    VBox vbox3 = new VBox(8);
    public SecondScene  (final String liczba_graczy)  {
        try {
            Liczba_Graczy liczba_graczy1 = new Liczba_Graczy (liczba_graczy);
        } catch (WyjatekException e) {
            e.printStackTrace();
        }
        Label Ile_Graczy = new Label("Wprowadzono liczbę graczy: " + liczba_graczy);
        Button przycisk2_ok =  new  Button();
        Label nazwy_graczy = new Label("Wprowadź nazwy graczy:");
        przycisk2_ok.setText("OK");
        // final Dodawanie_nazw dodawanie_nazw = new Dodawanie_nazw();
        final List<TextField> pola_tekstowe = new ArrayList<>(6);
        for ( int i = 0; i < Integer.parseInt(liczba_graczy); i++) {
            TextField a = new TextField ();
            pola_tekstowe.add(a);
            System.out.println(i);
        }
        przycisk2_ok.setOnAction(

                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) { // co robi przycisk ok

                    }
                }
        );
        for ( int i = 0; i < Integer.parseInt(liczba_graczy); i++) {
            vbox3.getChildren().addAll(pola_tekstowe.get(i));
        }
        vbox2.getChildren().addAll(Ile_Graczy, nazwy_graczy, vbox3, przycisk2_ok);
        Scene scene2 = new Scene(vbox2, 500, 500);
        Stage newWindow1 = new Stage(); //New window (Stage)
        newWindow1.setScene(scene2);
        newWindow1.show();
    }

}
