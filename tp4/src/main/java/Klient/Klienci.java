package Klient;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Klienci extends Application {

    private static BufferedReader in;
    private static PrintWriter out;
    static int [] liczby = new int[2];

    public static void main(String[] args) { launch(args); }

    public void start(final Stage pierwszastrona) throws IOException, InterruptedException {

        Drugie_okno d = new Drugie_okno ();

    }
    public static void go(String nazwa, Gwiazda g) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 22222);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        czekaj_na_sygnal(g);

    }

    public static void czekaj_na_sygnal(Gwiazda g) throws IOException, InterruptedException {

        String line = in.readLine();
        System.out.println("serwer wyslal: "+line);

        if ( line.equals("Czekaj")) {
            czekaj_na_sygnal(g);
        }

        else if (line.equals("Graj") ) {
                g.czekaj();
            czekaj_na_sygnal(g);

        }
        else {
            //System.out.println("metoda ktora powinna zmieniac gwiazde");
            out.println("12 15");
            czekaj_na_sygnal(g);
        }
    }
    public static void ustaw_liczby (int a, int b) throws IOException, InterruptedException {
        liczby[0] = a;
        liczby[1]  =b;
        wyslij();

    }
    public static void wyslij () throws IOException, InterruptedException {
        String uuu = liczby[0]+" "+liczby[1];
        out.println(uuu);
    }
}