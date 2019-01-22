package tp4;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Serwer  extends Application {


    //private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private static List<PrintWriter> wyjscia = new ArrayList<PrintWriter>();

    public static void main(String[] args) throws Exception {  launch(args); }


    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("USTAW NAZWĘ GRACZA");
        //Gwiazda g = new Gwiazda();
        ServerSocket listener = new ServerSocket(22222);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {
        int liczba_graczy = 1;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        public void run() {



            while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                wyjscia.add(out);
                 out.println("Czekaj");

            } catch (IOException e) {
                e.printStackTrace();
            }
            //int j =1;
            //if (wyjscia.size() == liczba_graczy ) {
                wyjscia.get(0).println("Graj");
            //}
            while (true) {
                String input = null;
                try {
                    input = in.readLine();
                    System.out.println("serwer dostał: "+input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
               for ( int i = 0; i< wyjscia.size(); i++) {
                    wyjscia.get(i).println(input);
                }
                wyjscia.get(0).println("Graj");
            }
            }
        }
    }
}
