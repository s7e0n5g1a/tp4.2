package Serwer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Gwiazda_serwera {

    private int klikacz = 0, lg;

    int [] przyciski = {-1, -1, -1, -1};

    static Button [] wszystkie_przyciski = new Button[221];

    public Gwiazda_serwera(int liczba) {
        Group grupa = new Group();
        int x = 0; //przesuwanie

        int licznik = 1; // po kolei kółka do kolorów

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 13; ++j) {
                if (i % 2 == 1) {
                    x = 30;
                } else {
                    x = 0;
                }

                Button bt = new Button();
                bt.setLayoutX(x + 30 + j * 60);
                bt.setLayoutY(30 + i * 60);
                KolorkiSerwer kk = new KolorkiSerwer(licznik, bt, liczba);
                wszystkie_przyciski[licznik - 1] = bt;
                licznik++;
            }
        }
        //grupa.getChildren().addAll(wszystkie_przyciski);
        //Scene trzecia_scena = new Scene(grupa, 1100, 1200);
        //Stage trzecia_strona = new Stage(); //New window (Stage)
        //trzecia_strona.setScene(trzecia_scena);
        //trzecia_strona.show(); // to pozniej trzeba usunac
    }
    static void zmiana(int a, int b) {
        Button [] zamien_przyciski = new Button[2];
        double x_1, x_2, y_1, y_2;

        zamien_przyciski[0] = wszystkie_przyciski[a];
        zamien_przyciski[1] = wszystkie_przyciski[b];
        x_1 = zamien_przyciski[0].getLayoutX();
        y_1 = zamien_przyciski[0].getLayoutY();
        x_2 = zamien_przyciski[1].getLayoutX();
        y_2 = zamien_przyciski[1].getLayoutY();
        zamien_przyciski[0].setLayoutX(x_2);
        zamien_przyciski[0].setLayoutY(y_2);
        zamien_przyciski[1].setLayoutX(x_1);
        zamien_przyciski[1].setLayoutY(y_1);
        System.out.println("zamieniono miejscami pryzciski "+a+" + "+b);
    }
}
