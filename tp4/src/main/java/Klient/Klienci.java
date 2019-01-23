package Klient;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klienci extends Application {

    private static BufferedReader in;
    private static PrintWriter out;

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
        System.out.println(line);
        String liczba_graczy = line;
        line = in.readLine();
        Gwiazda g = new Gwiazda(liczba_graczy,nazwa, line);
       // czekaj_na_sygnal();
    }

    private static void czekaj_na_sygnal() throws IOException {

        String line = in.readLine();
        System.out.println("serwer wyslal: "+line);
        if ( line.equals("Graj")) {
            out.println("aaa");
        }
    }
}