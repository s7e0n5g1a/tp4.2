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
    Button [] wszystkie_przyciski = new Button[221];
    String nazwa_gracza;
    public void start(final Stage pierwszastrona) throws IOException, InterruptedException {


        pierwszastrona.setTitle("USTAW NAZWĘ GRACZA");
        Drugie_okno d = new Drugie_okno ();

    }
    public static void main(String[] args) { launch(args); }

    public static void go(String nazwa) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 11111);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String line = in.readLine();
            if (line.startsWith("SUBMITNAME")) {
                out.println(nazwa);
            } else if (line.startsWith("STARTGAME")) {
                Gwiazda g = new Gwiazda(3);
            } else if (line.startsWith("MESSAGE")) {
                System.out.println(line+"\n");
                //messageArea.append(line.substring(8) + "\n");
            }
        }
    }
}