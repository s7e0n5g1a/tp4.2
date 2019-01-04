package tp4;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Gwiazda{
    private int klikacz = 0;
    private double x_1, x_2, y_1, y_2;

    public Gwiazda () {

        Group grupa = new Group();
        int x = 0; //przesuwanie
        Button [] zamien_przyciski = new Button[2];
        int []  numer_w_tablicy  = new int [2];
        int licznik = 1; // po kolei kółka do kolorów
        Button [] wszystkie_przyciski = new Button[221];

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 13; ++j) {
                if ( i%2 == 1)  {  x = 30; }
                else { x = 0; }

            Button bt = new Button();   bt.setLayoutX(x+30+j*80); bt.setLayoutY(30+i*60);
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                                "-fx-min-width: 40px; " +
                                "-fx-min-height: 40px; " +
                                "-fx-max-width: 40px; " +
                                "-fx-max-height: 40px;"
                );
                Kolorki kk = new Kolorki( licznik,  bt);
                bt.setOnAction(
                        event -> { // co robi przycisk bt

                            if (klikacz == 1){
                                zamien_przyciski[klikacz] = bt;
                                x_1 = zamien_przyciski[0].getLayoutX();
                                y_1 = zamien_przyciski[0].getLayoutY();
                                x_2 = zamien_przyciski[1].getLayoutX();
                                y_2 = zamien_przyciski[1].getLayoutY();
                                zamien_przyciski[0].setLayoutX(x_2);
                                zamien_przyciski[0].setLayoutY(y_2);
                                zamien_przyciski[1].setLayoutX(x_1);
                                zamien_przyciski[1].setLayoutY(y_1);
                                klikacz = 0;
                            }
                            else if (klikacz == 0) {

                                zamien_przyciski[klikacz] = bt;
                                klikacz++;
                            }
                        }
                );
                wszystkie_przyciski[licznik-1] =  bt;
                licznik ++;
            }
        }
        grupa.getChildren().addAll(wszystkie_przyciski);
       // grupa.getChildren().addAll(zamien_przyciski);
        Scene trzecia_scena = new Scene(grupa, 1100, 1200);
        Stage trzecia_strona = new Stage(); //New window (Stage)
        trzecia_strona.setScene(trzecia_scena);
        trzecia_strona.show();

    }

}
