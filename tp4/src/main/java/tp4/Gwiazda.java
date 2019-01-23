package tp4;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class Gwiazda{

    private int klikacz = 0, lg;
    private double x_1, x_2, y_1, y_2;
    int [] przyciski = {-1, -1, -1, -1};
    Button [] zamien_przyciski = new Button[2];
    Button [] wszystkie_przyciski = new Button[221];
    int [] a = new int[4];
    int loop = 0;
    public Gwiazda () throws IOException, InterruptedException {

            int lg = 1;

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
                        Kolorki kk = new Kolorki(licznik, bt, lg);

                        bt.setOnAction(
                                event -> { // co robi przycisk bt
                                    if ((bt.getText() != "0")) {
                                        if ((klikacz == 1)) {

                                            zamien_przyciski[klikacz] = bt;
                                            przyciski[0] = Integer.parseInt(zamien_przyciski[0].getText());
                                            przyciski[1] = Integer.parseInt(zamien_przyciski[1].getText());
                                            klikacz = 0;
                                            if (loop == 0) {
                                                a[0] = przyciski[0];
                                                a[1] = przyciski[1];
                                                loop++;
                                            } else if (loop == 1) {
                                                a[2] = przyciski[0];
                                                a[3] = przyciski[1];
                                                loop--;
                                            }
                                            try {
                                                Klienci.ustaw_liczby(przyciski[0], przyciski[1]);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        } else if (klikacz == 0) {
                                            zamien_przyciski[klikacz] = bt;
                                            klikacz++;
                                        }
                                    }
                                    //System.out.println(bt.getText());
                                }
                        );
                        wszystkie_przyciski[licznik - 1] = bt;
                        licznik++;
                    }
                }
                grupa.getChildren().addAll(wszystkie_przyciski);
                Scene trzecia_scena = new Scene(grupa, 1100, 1200);
                Stage trzecia_strona = new Stage(); //New window (Stage)
                trzecia_strona.setScene(trzecia_scena);
                trzecia_strona.show();
                    try {
                        czekaj();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
    }
    public void czekaj () throws IOException, InterruptedException {
        while ( a[0] != -1 && a[1] != -1 &&  a[2] != -1 && a[3] != -1 && a[1] != a[3] && a[0] != a[1]  ) {
            Klienci.ustaw_liczby(przyciski[0], przyciski[1] );
        }
    }
}
