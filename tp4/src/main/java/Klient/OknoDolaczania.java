package Klient;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OknoDolaczania {
    Stage strona;
    Text infoText;
    Button okButton;

    public OknoDolaczania(Klient klient) {
        VBox vbox1 = new VBox(8);

        Label nazwaGraczaLabel = new Label("Wprowadź nazwę gracza:");
        final TextField nazwaGraczaTextField = new TextField();
        okButton =  new Button("Dołącz do gry");
        infoText = new Text("");

        vbox1.getChildren().addAll(nazwaGraczaLabel, nazwaGraczaTextField, okButton, infoText);
        Scene scena = new Scene(vbox1, 500, 500);
        strona = new Stage();
        strona.setScene(scena);
        strona.setTitle("Laczenie z gra");
        strona.show();

        okButton.setOnAction(event -> klient.polacz(nazwaGraczaTextField.getText()));
    }

    public void close() {
        strona.close();
    }

    public void wyswietlInfo(String msg) {
        infoText.setText(msg);
        okButton.setDisable(true);
    }
}
