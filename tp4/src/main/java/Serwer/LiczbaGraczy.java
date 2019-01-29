package Serwer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class LiczbaGraczy {
    LiczbaGraczy (Serwer serwer) {
        Label liczbaGraczyLabel= new Label("Wprowadź liczbę graczy:");
        final TextField liczbaGraczyTextField = new TextField();

        Label liczbaBotowLabel = new Label("Wprowadź liczbę botów:");
        final TextField liczbaBotowTextField = new TextField ();

        Button okButton =  new Button("Rozpocznij");

        Label errorLabel = new Label("");

        VBox vBox = new VBox(8, liczbaGraczyLabel, liczbaGraczyTextField, liczbaBotowLabel, liczbaBotowTextField, okButton, errorLabel);

        Scene scene = new Scene(vBox, 500, 500);
        Stage stage = new Stage(); //New window (Stage)
        stage.setTitle("Ile graczy");
        stage.setScene(scene);
        stage.show();

        okButton.setOnAction(
                event -> {
                    int gracze = Integer.parseInt(liczbaGraczyTextField.getText());
                    int boty = Integer.parseInt(liczbaBotowTextField.getText());

                    if ( gracze < 0 || gracze > 6) {
                        errorLabel.setText("Podano nieprawidłową liczbę graczy");
                    } else if ( boty < 0 || boty > 6) {
                        errorLabel.setText("Podano nieprawidłową liczbę botów");
                    } else if ( gracze + boty > 6 || gracze + boty == 5)  {
                        errorLabel.setText("Podano złą liczbe uczestników");
                    } else {
                        // Nie wyłączam okna, bo można dodać do niego jakieś informacje, albo opcje w stylu zresetuj serwer
                        okButton.setDisable(true);
                        serwer.ustawDane(gracze, boty);
                    }
                }
        );
    }
}
