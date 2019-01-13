package tp4;

import javafx.scene.control.Button;
public class Kolorki {


    public Kolorki (int licznik, Button btn, int lg) {
        Button bt = btn;
        int zmiana = 3;

        int tablica_kolorow[] = {0, 0, 0, 0, 0, 0};


         switch ( lg) {
             case 1: {
                 tablica_kolorow[0] = 1;
             }
             break;
             case 2: {
                 tablica_kolorow[0] = 1;
                 tablica_kolorow[1] = 1;
             }
             break;
             case 3: {
                 tablica_kolorow[0] = 1;
                 tablica_kolorow[1] = 1;
                 tablica_kolorow[2] = 1;
             }
             break;
             case 4: {
                 tablica_kolorow[0] = 1;
                 tablica_kolorow[1] = 1;
                 tablica_kolorow[2] = 1;
                 tablica_kolorow[3] = 1;

             }
             break;
             case 6: {
                 tablica_kolorow[0] = 1;
                 tablica_kolorow[1] = 1;
                 tablica_kolorow[2] = 1;
                 tablica_kolorow[3] = 1;
                 tablica_kolorow[4] = 1;
                 tablica_kolorow[5] = 1;
             }
             break;
         }


        bt.setText(String.valueOf(licznik));
        bt.setStyle(
                "-fx-background-radius: 500em; " +
                        "-fx-background-color: WHITE; " +
                        "-fx-text-fill: WHITE; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;"
        );
        int lososiowe[]  = {57, 58, 59, 60, 61, 69, 70, 71, 72, 73, 74, 82, 83, 84, 85, 86, 87, 88, 94, 95, 96, 97, 98,
                99, 100, 101, 107, 108, 109, 110, 111,112, 113, 114, 115, 120, 121, 122, 123, 124, 125, 126, 127, 134,
                135, 136, 137, 138, 139, 140, 147, 148, 149, 150, 151, 152, 161, 162, 163, 164, 165};
        int l = licznik;
        for ( int i = 0; i<61; i++) {
            if ( licznik == lososiowe[i]) {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                                "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
            }
        }
        switch (l) {
            case 7: case 19: case 20: case 32: case 33: case 34: case 44: case 45: case 46: case 47: {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                                "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
                if ( tablica_kolorow[0] == 1) {
                    bt.setStyle(
                            "-fx-background-radius: 500em; " +
                                    "-fx-background-color: RED; " +
                                    "-fx-text-fill: RED; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;"
                    );
                }
            }
                break;
            case 62: case 63: case 64: case 65: case 75: case 76: case 77: case 89: case 90: case 102: {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                                "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
                if ( tablica_kolorow[1] == 1) {
                    bt.setStyle(
                            "-fx-background-radius: 500em; " +
                                    "-fx-background-color: ROYALBLUE; " +
                                    "-fx-text-fill: ROYALBLUE; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;"
                    );
                }
            }
            break;
            case 53: case 54: case 55: case 56: case 66: case 67: case 68: case 80: case 81: case 93: {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                                "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
                if ( tablica_kolorow[2] == 1) {
                    bt.setStyle(
                            "-fx-background-radius: 500em; " +
                                    "-fx-background-color: YELLOW; " +
                                    "-fx-text-fill: YELLOW; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;"
                    );
                }

            }
                break;
            case 119: case 132: case 133: case 144: case 145: case 146: case 157: case 158: case 159: case 160: {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                                "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
                if ( tablica_kolorow[3] == 1) {
                    bt.setStyle(
                            "-fx-background-radius: 500em; " +
                                    "-fx-background-color: GREEN; " +
                                    "-fx-text-fill: GREEN; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;"
                    );
                }
            }
                break;
            case 174: case 175: case 176: case 177: case 188: case 189: case 190: case 201: case 202: case 215: {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                        "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
                if ( tablica_kolorow[4] == 1) {
                    bt.setStyle(
                            "-fx-background-radius: 500em; " +
                                    "-fx-background-color: BROWN; " +
                                    "-fx-text-fill: BROWN; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;"
                    );
                }
            }
                break;
            case 128: case 142: case 141: case 155: case 154: case 153: case 169: case 168: case 167: case 166: {
                bt.setStyle(
                        "-fx-background-radius: 500em; " +
                        "-fx-background-color: SALMON; " +
                                "-fx-text-fill: SALMON; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;"
                );
                if ( tablica_kolorow[5] == 1) {
                    bt.setStyle(
                            "-fx-background-radius: 500em; " +
                                    "-fx-background-color: BLUE; " +
                                    "-fx-text-fill: BLUE; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;"
                    );
                }
            }
                break;
       }

       String buttonText = bt.getStyle();
        if(buttonText=="-fx-background-radius: 500em; -fx-background-color: WHITE; -fx-text-fill: WHITE; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;")
        {
            bt.setText(String.valueOf(0)); //pola poza plansza maja napis "0" - zero
        }

    }

}