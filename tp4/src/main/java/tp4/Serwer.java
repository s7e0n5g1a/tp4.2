package tp4;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Serwer extends Application {

    private static ServerSocket serwer;
    private static String localhost = "127.0.0.1";

    public void start(final Stage pierwszastrona)  {

        pierwszastrona.setTitle("Chinese Checkers");
        Pierwsze_okno pierwsza_strona = new Pierwsze_okno(pierwszastrona);
    }

    public static void main(String[] args) throws IOException {
        serwer = new ServerSocket(2222);
        System.out.println("Serwer dziala");
        launch(args);
    }

    public void rozgrywka (List<Klienci> klienci) throws IOException {
        for ( int i = 0; i < klienci.size(); i++ ) {
            klienci.get(i).start();
        }
        while (true) {

            Socket socket = serwer.accept();

            //try {
            //    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //    String answer = input.readLine();
            //    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //} finally {
                // socket.close();
            //}
        }
    }
}

