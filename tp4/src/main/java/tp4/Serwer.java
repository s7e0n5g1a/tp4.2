package tp4;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;


public class Serwer extends Application {

    private static ServerSocket serwer;
    private static String localhost = "127.0.0.1";

    public void start(final Stage pierwszastrona)  {

        pierwszastrona.setTitle("Chinese Checkers");
        Pierwsze_okno pierwsza_strona = new Pierwsze_okno(pierwszastrona);
    }

    public static void main(String[] args) throws IOException {
        serwer = new ServerSocket(2222); // tutaj serwer sie uruchamai normalnie
        System.out.println("Serwer dziala");
        launch(args);
    }

    public void rozgrywka (List<Klienci> klienci) throws IOException {
        for ( int i = 0; i < klienci.size(); i++ ) {

            //klienci.get(i).start(); // w tym miejscu chce dodac gniazda do klientow
        }

        // tutaj już serwer powinien łączyc sie z klientami, ale nie działa
        // trzeba jeszcze dodać do kilentów jakies gniazda, buffory itd
        //while (true) { //

        /*
            Socket socket = serwer.accept();

        try {
               BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String answer = input.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        } finally {
                 socket.close();
            }
        */
    }
}

