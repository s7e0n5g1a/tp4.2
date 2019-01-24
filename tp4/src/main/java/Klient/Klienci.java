package Klient;

import javafx.application.Application;
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
    static String kolor;
    static Gwiazda g;
    public static void main(String[] args) { launch(args); }

    public void start(final Stage pierwszastrona) throws IOException, InterruptedException {
        Drugie_okno drugie_okno = new Drugie_okno ();
    }
    public static void go(String nazwa) throws IOException, InterruptedException {
        System.out.println(nazwa);
        Socket socket = new Socket("127.0.0.1", 22222);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        String line = in.readLine();
        String liczba_graczy = line;
        line = in.readLine();
        kolor = line;
        g = new Gwiazda(liczba_graczy,nazwa, kolor);

    }
    public static void zacznij_gre() throws IOException, InterruptedException {
        out.println("nic");
        System.out.println("wysylam nic");
         String line = in.readLine();
        if ( line.equals("Start"))
            czekaj_na_sygnal();
    }
     static void czekaj_na_sygnal() throws IOException, InterruptedException {
//System.out.println("czkeam");
        String line = in.readLine();
         if ( line.equals("ustaw kolor")) {
             line = in.readLine();
             g.ustaw_kolej(line);
         }
        if ( line.equals(kolor)) {
            g.ustaw_kolej(line);
            sleep(10000);
            //czekaj_na_sygnal();
        }
        //else czekaj_na_sygnal();


    }
}