package tp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klienci {
    static String nazwa_klienta;
    private static String b;
    private static int c;

    public Klienci ( String a) throws IOException {
        nazwa_klienta = a;

        System.out.println("Stworzono gracza: " + nazwa_klienta);

    }

    public void start () throws IOException {

        Gwiazda plansza = new Gwiazda();
        Socket s = new Socket(b, 2222);

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);// Wyświtlenie okna z pytaniem do użytkownika i pobranie jego odpowiedzi
        //out.println(t);  zapis do bufora zapisu - wysłanie wiadomości do klienta
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));// tworzenie buforu odczytu
        String answer = input.readLine(); //odczyt linii z bufora odczytu
        //JOptionPane.showMessageDialog(null, answer); wyświtlenie MsgBoxa z otrzymaną odpowiedzią serwera
        s.close();
        System.exit(0);

    }

}