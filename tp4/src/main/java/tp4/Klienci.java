package tp4;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Klienci {

    private static DataOutput do_serwera;
    int klikacz = 0;

    private double x_1, x_2, y_1, y_2;
    int [] przyciski = new int[2];
    Button [] wszystkie_przyciski = new Button[221];
    String a;

    public Klienci ( String a) throws IOException {


        int lg;
        Button [] zamien_przyciski = new Button[2];
        String nazwa_klienta = a;
        //Gwiazda plansza = new Gwiazda(Pierwsze_okno.zwroc_lg());
        System.out.println("Stworzono klienta " +a );
        Socket socketConnection = new Socket("127.0.0.1", 11111);
        do_serwera = new DataOutputStream(socketConnection.getOutputStream());
        //do_serwera.writeUTF("dfsdf");

        Pierwsze_okno.zwroc_lg ();

        lg = Pierwsze_okno.zwroc_lg ();
        Group grupa = new Group();
        int x = 0; //przesuwanie
        int licznik = 1; // po kolei kółka do kolorów


        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 13; ++j) {
                if ( i%2 == 1)  {  x = 30; }
                else { x = 0; }

                Button bt = new Button();   bt.setLayoutX(x+30+j*60); bt.setLayoutY(30+i*60);
                Kolorki kk = new Kolorki( licznik,  bt, lg );

                bt.setOnAction(
                        event -> { // co robi przycisk bt
                            if((bt.getText()!="0")) {
                                if ((klikacz == 1)) {
                                    zamien_przyciski[klikacz] = bt;
                                    try {
                                        do_serwera.writeUTF(
                                        nazwa_klienta+": "+zamien_przyciski[0].getText()+" "+zamien_przyciski[1].getText());
                                        klikacz = 0;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else if (klikacz == 0) {
                                    zamien_przyciski[klikacz] = bt;
                                    klikacz++;
                                }
                            }
                        }
                );
                wszystkie_przyciski[licznik-1] =  bt;
                licznik ++;
            }
        }
        grupa.getChildren().addAll(wszystkie_przyciski);
        Scene trzecia_scena = new Scene(grupa, 1100, 1200);
        Stage trzecia_strona = new Stage(); //New window (Stage)
        trzecia_strona.setScene(trzecia_scena);
        trzecia_strona.show();
    }
}