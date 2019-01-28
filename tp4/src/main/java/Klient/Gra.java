package Klient;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Klasa, która nazywała się Gwiazda, zawiera główne okno gry
 */
class Gra {
    // Dodatek do zaznaczania, który klikniety
    private Border borderNaZaznaczony = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    private int liczbaGraczy;
    private Button[] wszystkie_przyciski = new Button[221];

    private Button ruchButton;
    private Label terazGraLabel;
    private Group interfejsGroup;

    private ArrayList<Integer> numeryPrzyciskowDoZmiany = new ArrayList<>(2);

    Gra(Klient klient) {
        liczbaGraczy = klient.liczbaGraczy;
        interfejsGroup = new Group();

        Label graczLabel = new Label("Gracz: " + klient.nazwa);
        Label kolorLabel = new Label("Kolor: " + klient.kolor);
        terazGraLabel = new Label();
        ruchButton = new Button("Wykonaj ruch");

        VBox infoGraczVBox = new VBox(graczLabel, kolorLabel, terazGraLabel, ruchButton);

        ruchButton.setOnAction(
            event -> {
                // Wykonaj ruch tylko jak są dwie kulki zaznaczone
                if (numeryPrzyciskowDoZmiany.size() == 2) {
                    klient.wykonajRuch(numeryPrzyciskowDoZmiany);
                    numeryPrzyciskowDoZmiany.clear();
                    resetujWszystkimWygladKlikniecia();
                } else {
                    // Tutaj można dodać jakieś info jak ktoś klika przycisk, a nie ma zaznaczonych pól
                    System.out.println("ZAZNACZ DWA PRZYCISKI");
                }
            }
        );

        // Wydzielone generowanie gwiazdy do osobnej metody
        stworzGwiazde();
        interfejsGroup.getChildren().add(infoGraczVBox);
        Scene trzecia_scena = new Scene(interfejsGroup, 1100, 1200);
        Stage trzecia_strona = new Stage();
        trzecia_strona.setScene(trzecia_scena);
        trzecia_strona.setTitle("Gra " + klient.kolor);
        trzecia_strona.show();
    }

    private void stworzGwiazde() {
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
                new Kolorki(licznik, bt, liczbaGraczy);

                bt.setOnAction(
                    event -> {
                        // Dzialanie klikania zrobiłem tak, że
                        // Po kliknięciu 3 raz w cokolwiek resetują się kliknięcia i klika się na nowo
                        int nr = Integer.parseInt(bt.getText());
                        if (numeryPrzyciskowDoZmiany.size() == 0) {
                            numeryPrzyciskowDoZmiany.add(0, nr);
                            bt.setBorder(borderNaZaznaczony);
                        } else if (numeryPrzyciskowDoZmiany.size() == 1) {
                            numeryPrzyciskowDoZmiany.add(1, nr);
                            bt.setBorder(borderNaZaznaczony);
                        } else {
                            resetujWszystkimWygladKlikniecia();
                            numeryPrzyciskowDoZmiany.clear();
                        }
                        System.out.println("Kliknięto przycisk nr: " + nr);
                    }
                );
                wszystkie_przyciski[licznik - 1] = bt;
                licznik++;
            }
        }
        interfejsGroup.getChildren().addAll(wszystkie_przyciski);
    }

    /**
     * Metoda wykonująca ruch
     * IMO cieżko to bedzie bez tej tablicy bo nie ma za bardzo informacji jakie podmieniać
     * Zrobiłem podmiane tekstu na buttonach i ich pozycji (co ciekawe tekst się chyba nie zmienia xD)
     */
    void ruch(String buttonA, String buttonB) {
        int indexA = znajdzIndexButtona(buttonA);
        int indexB = znajdzIndexButtona(buttonB);

        String tmpText = wszystkie_przyciski[indexA].getText();
        double tmpLayoutX = wszystkie_przyciski[indexA].getLayoutX();
        double tmpLayoutY = wszystkie_przyciski[indexA].getLayoutY();

        wszystkie_przyciski[indexA].setText(wszystkie_przyciski[indexB].getText());
        wszystkie_przyciski[indexA].setLayoutX(wszystkie_przyciski[indexB].getLayoutX());
        wszystkie_przyciski[indexA].setLayoutY(wszystkie_przyciski[indexB].getLayoutY());

        wszystkie_przyciski[indexB].setText(tmpText);
        wszystkie_przyciski[indexB].setLayoutX(tmpLayoutX);
        wszystkie_przyciski[indexB].setLayoutY(tmpLayoutY);
    }

    private int znajdzIndexButtona(String tekstNaButtonie) {
        int index = -1;
        for (int i=0; i < wszystkie_przyciski.length && index == -1; i++) {
            if (wszystkie_przyciski[i].getText().equals(tekstNaButtonie)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Dostaje kolor gracza i info czy jego kolei i na tej podstawie
     * Wyłącza przycisk i ustawia label z info czyj ruch
     */
    void ustawAktualnegoGracza(String kolorGracza, boolean czyMojaKolej) {
        if (czyMojaKolej) {
            ruchButton.setDisable(false);
        } else {
            ruchButton.setDisable(true);
        }
        terazGraLabel.setText("Teraz gra gracz: " + kolorGracza);
    }

    private void resetujWszystkimWygladKlikniecia() {
        for (Button btn:wszystkie_przyciski) {
            btn.setBorder(Border.EMPTY);
        }
    }
}
