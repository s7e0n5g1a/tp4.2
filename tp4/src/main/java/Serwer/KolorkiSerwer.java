package Serwer;

import javafx.scene.control.Button;

public class KolorkiSerwer {
    public KolorkiSerwer(int licznik, Button btn, int lg) {
        Button bt = btn;
        int zmiana = 3;

        int tablica_kolorow[] = {0, 0, 0, 0, 0, 0};

        // skróciłem switch z caseami do petli for
        for(int i = 0; i < lg; i++) {
            tablica_kolorow[i] = 1;
        }

        bt.setText(String.valueOf(licznik));
/*
        bt.setStyle(
            "-fx-background-radius: 500em; "
            + "-fx-background-color: RED; "
            + "-fx-text-fill: RED; "
            + "-fx-min-width: 30px; "
            + "-fx-min-height: 30px; "
            + "-fx-max-width: 30px; "
            + "-fx-max-height: 30px;"
        );
*/
        // Zrobiłem zmienne ze stylami (można to zrobić i tak lepiej)
        String uniwersalny = bt.getStyle();
        String stylSalmon = "-fx-background-radius: 500em; -fx-background-color: SALMON; -fx-text-fill: SALMON; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        String stylRoyalblue = "-fx-background-radius: 500em; -fx-background-color: ROYALBLUE; -fx-text-fill: ROYALBLUE; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        String stylYellow = "-fx-background-radius: 500em; -fx-background-color: YELLOW; -fx-text-fill: YELLOW; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        String stylGreen = "-fx-background-radius: 500em; -fx-background-color: GREEN; -fx-text-fill: GREEN; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        String stylRed = "-fx-background-radius: 500em; -fx-background-color: RED; -fx-text-fill: RED; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        String stylBrown = "-fx-background-radius: 500em; -fx-background-color: BROWN; -fx-text-fill: BROWN; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        String stylBlue = "-fx-background-radius: 500em; -fx-background-color: BLUE; -fx-text-fill: BLUE; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";

        //String stylSalmon = uniwersalny + "-fx-background-color: SALMON; -fx-text-fill: SALMON;";
        //String stylRoyalblue = uniwersalny + "-fx-background-color: ROYALBLUE; -fx-text-fill: ROYALBLUE;";
        //String stylYellow = uniwersalny + "-fx-background-color: YELLOW; -fx-text-fill: YELLOW;";
        //String stylGreen = uniwersalny + "-fx-background-color: GREEN; -fx-text-fill: GREEN;";
        //String stylRed = uniwersalny + "-fx-background-color: RED; -fx-text-fill: RED;";
        //String stylBrown = uniwersalny + "-fx-background-color: BROWN; -fx-text-fill: BROWN;";
        //String stylBlue = uniwersalny + "-fx-background-color: BLUE; -fx-text-fill: BLUE;";

        int lososiowe[]  = {57, 58, 59, 60, 61, 69, 70, 71, 72, 73, 74, 82, 83, 84, 85, 86, 87, 88, 94, 95, 96, 97, 98,
                99, 100, 101, 107, 108, 109, 110, 111,112, 113, 114, 115, 120, 121, 122, 123, 124, 125, 126, 127, 134,
                135, 136, 137, 138, 139, 140, 147, 148, 149, 150, 151, 152, 161, 162, 163, 164, 165};

        for(int i = 0; i < 61; i++) {
            if(licznik == lososiowe[i]) {
                bt.setStyle(stylSalmon);
            }
        }

        switch (licznik) {
            case 7: case 19: case 20: case 32: case 33: case 34: case 44: case 45: case 46: case 47: {
                bt.setStyle(stylSalmon);

                if ( tablica_kolorow[0] == 1) {
                    bt.setStyle(stylRed);
                    // System.out.println("WOWOOWOWOW");
                }
            }
            break;
            case 62: case 63: case 64: case 65: case 75: case 76: case 77: case 89: case 90: case 102: {
                bt.setStyle(stylSalmon);
                if ( tablica_kolorow[1] == 1) {
                    bt.setStyle(stylBlue);
                }
            }
            break;
            case 53: case 54: case 55: case 56: case 66: case 67: case 68: case 80: case 81: case 93: {
                bt.setStyle(stylSalmon);
                if ( tablica_kolorow[2] == 1) {
                    bt.setStyle(stylYellow);
                }

            }
            break;
            case 119: case 132: case 133: case 144: case 145: case 146: case 157: case 158: case 159: case 160: {
                bt.setStyle(stylSalmon);
                if ( tablica_kolorow[3] == 1) {
                    bt.setStyle(stylGreen);
                }
            }
            break;
            case 174: case 175: case 176: case 177: case 188: case 189: case 190: case 201: case 202: case 215: {
                bt.setStyle(stylSalmon);
                if ( tablica_kolorow[4] == 1) {
                    bt.setStyle(stylBrown);
                }
            }
            break;
            case 128: case 142: case 141: case 155: case 154: case 153: case 169: case 168: case 167: case 166: {
                bt.setStyle(stylSalmon);
                if ( tablica_kolorow[5] == 1) {
                    bt.setStyle(stylRoyalblue);
                }
            }
            break;
        }
        //System.out.println("OOOOOOOOOOOOOOOOOOOO");
        if(bt.getStyle().equals(uniwersalny)) {
            bt.setText(String.valueOf(0)); //pola poza plansza maja napis "0" - zero
        }
    }

}