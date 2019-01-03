package tp4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttoner {
//ioioiosrgwrg
    Button przycisk1_ok =  new  Button();

    public  Buttoner (final Stage primaryStage)  {

        VBox vbox1 = new VBox(8);
        Label ilosc_graczy = new Label("Wprowadź ilość graczy:"); //napis
        final TextField ilosc_g = new TextField ();
        przycisk1_ok.setText("OK");
        vbox1.getChildren().addAll(ilosc_graczy,ilosc_g, przycisk1_ok);
        Scene scene1 = new Scene(vbox1, 500, 500);
        primaryStage.setScene(scene1);
        primaryStage.show();
        przycisk1_ok.setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) { // co robi przycisk ok
                        SecondScene secondscene =  new SecondScene(ilosc_g.getText());
                        primaryStage.close();
                    }
                }
        );

    }

}
