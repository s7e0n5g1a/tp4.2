package tp4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SecondScene {
    String []tablica_nazw =  new String [6];
    VBox vbox2 = new VBox(8);

    public SecondScene  (String liczba_graczy)  {
        try {
            Liczba_Graczy liczba_graczy1 = new Liczba_Graczy (liczba_graczy);
        } catch (WyjatekException e) {
            e.printStackTrace();
        }
        Label Ile_Graczy = new Label("Wprowadzono liczbę graczy: " + liczba_graczy);
        Button przycisk2_ok =  new  Button();
        Label nazwy_graczy = new Label("Wprowadź nazwy graczy:");
        final TextField nazwy = new TextField ();
        przycisk2_ok.setText("OK");
        final Dodawanie_nazw dodawanie_nazw = new Dodawanie_nazw();

            przycisk2_ok.setOnAction(

                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) { // co robi przycisk ok
                            for ( int i = 0; i < 5; i++) {
                            tablica_nazw[i] = dodawanie_nazw.dodaj(nazwy);
                            System.out.println(i);
                            }
                        }
                    }
            );


        vbox2.getChildren().addAll(Ile_Graczy, nazwy_graczy, nazwy, przycisk2_ok);
        Scene scene2 = new Scene(vbox2, 500, 500);
        Stage newWindow1 = new Stage(); //New window (Stage)
        newWindow1.setScene(scene2);
        newWindow1.show();
    }

}
