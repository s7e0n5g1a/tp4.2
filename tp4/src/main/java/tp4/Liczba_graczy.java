package tp4;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Liczba_graczy {

    public static void ustaw () {

        VBox vbox1 = new VBox(8);
        Label l1 = new Label("Wprowadź liczbę graczy:");
        final TextField tf1 = new TextField ();
        Label l2 = new Label("Wprowadź liczbę botów:");
        final TextField tf2 = new TextField ();
        Button przycisk_ok =  new  Button();
        Label l3 = new Label("");
        przycisk_ok.setText("Rozpocznij grę");
        vbox1.getChildren().addAll(l1, tf1, l2, tf2, przycisk_ok, l3);
        Scene scene1 = new Scene(vbox1, 500, 500);
        Stage stage1 = new Stage(); //New window (Stage)
        stage1.setScene(scene1);
        stage1.show();

        przycisk_ok.setOnAction(
                event -> {

                    int x = Integer.parseInt(tf1.getText());
                    int y = Integer.parseInt(tf2.getText());
                    if ( x != 0 && x != 1 && x != 2 && x != 3 && x != 4 && x != 6)
                        l3.setText("Podano nieprawidłową liczbę graczy");
                    else if ( y != 0 && y != 1 && y != 2 && y != 3 && y != 4 && y != 6)
                        l3.setText("Podano nieprawidłową liczbę botów");
                    else if ( !(x+y > 0 && x+y < 7) )
                        l3.setText("Podano zbyt dużą liczbę uczestników gry");
                    else {
                        stage1.close();
                        Serwer.ustaw_dane(tf1.getText(), tf2.getText());
                        try {
                            Serwer.gogo();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }
        );
    }
}
