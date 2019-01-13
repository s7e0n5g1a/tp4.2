package tp4;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Stworz_klientow {

    final List<Klienci> klienci = new ArrayList<>(6); // lista ze wszytskimi klientami

    public  Stworz_klientow (List<TextField> pola_tekstowe, int lg) throws IOException {

        for ( int i = 0; i< lg; i++) {
            Klienci x =  new Klienci(pola_tekstowe.get(i).getText());
            klienci.add(x);
            Gwiazda g = new Gwiazda();
        }
        Serwer a = new Serwer(); // tworze obiekt serwer, zeby wrocic do klasy, ktora rozpoczęła program
        a.rozgrywka(klienci); // zaczynamy grę wraz z ruchami i walidacją ruchów
    }
}
