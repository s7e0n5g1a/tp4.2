package tp4;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Drugie_okno {

    final List<Klienci> klienci = new ArrayList<>(6);
    final List<TextField> pola_tekstowe = new ArrayList<>(6);
    int lg;
    public Drugie_okno  (final String liczba_graczy)  {
        lg = Integer.parseInt(liczba_graczy);
        VBox vbox2 = new VBox(8);
        VBox vbox3 = new VBox(8);
        try {
            Liczba_Graczy liczba_graczy1 = new Liczba_Graczy (liczba_graczy);
        } catch (WyjatekException e) {
            e.printStackTrace();
        }
        Label Ile_Graczy = new Label("Wprowadzono liczbę graczy: " + liczba_graczy);
        Button przycisk2_ok =  new  Button();
        Label nazwy_graczy = new Label("Wprowadź nazwy graczy:");
        przycisk2_ok.setText("OK");

        for ( int i = 0; i < Integer.parseInt(liczba_graczy); i++) {
            TextField a = new TextField ();
            pola_tekstowe.add(a);
        }

        for ( int i = 0; i < Integer.parseInt(liczba_graczy); i++) {
            vbox3.getChildren().addAll(pola_tekstowe.get(i));
        }
        vbox2.getChildren().addAll(Ile_Graczy, nazwy_graczy, vbox3, przycisk2_ok);
        Scene druga_scena = new Scene(vbox2, 500, 500);
        Stage druga_strona = new Stage(); //New window (Stage)
        druga_strona.setScene(druga_scena);
        druga_strona.show();
        przycisk2_ok.setOnAction(
                event -> { // co robi przycisk ok
                    try {
                        Serwer s = new Serwer();
                        stworz_klienta( s.zwroc_localhost(), s.zwroc_port());
                        druga_strona.close();
                        //Gwiazda plansza = new Gwiazda();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Gwiazda plansza =  new Gwiazda();
                }
        );
    }
    void stworz_klienta (String a, int b) throws IOException {
        String c = a;
        int d = b;
        for ( int i = 0; i < lg; i++) {
            Klienci x =  new Klienci(pola_tekstowe.get(i).getText(), c, d);
            klienci.add(x);
        }
    }
}
