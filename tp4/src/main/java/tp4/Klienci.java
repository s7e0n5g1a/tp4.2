package tp4;

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


    int klikacz = 0;
    private static BufferedReader in;
    private static PrintWriter out;
    Gwiazda g;

    public void start(final Stage pierwszastrona) throws IOException, InterruptedException {


        pierwszastrona.setTitle("USTAW NAZWĘ GRACZA");
        Drugie_okno d = new Drugie_okno ();

    }
    public static void main(String[] args) { launch(args); }

    public static void ustaw_liczby (int a, int b) throws IOException {
        int [] liczby = new int[2];
        liczby[0] = a;
        liczby[1]  =b;
        String uuu = a+" "+b;
        out.println(uuu);
        czekaj_na_sygnal();
    }

        public static void czekaj_na_sygnal() throws IOException {
            String line = in.readLine();
            System.out.println("serwer wyslal: "+line);
        }
    public static void go(String nazwa) throws IOException, InterruptedException {


        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("utworzono socketa");
        Gwiazda g = new Gwiazda();
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    }
}