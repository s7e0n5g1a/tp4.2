package Serwer;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serwer  extends Application {

    private static List<PrintWriter> wyjscia = new ArrayList<PrintWriter>();
    static String liczba_botow, liczba_graczy;
    static String kolory[] = {"czerwony", "niebieski", "żółty", "zielony", "brązowy", "granatowy"};
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("START");
        Liczba_graczy.ustaw();

    }

    public static void ustaw_dane(String a, String b) {
        liczba_graczy = a;
        liczba_botow = b;
        System.out.println("Liczba graczy: " + a);
        System.out.println("Liczba botów: " + b);
    }


    public static void gogo() throws IOException {

        System.out.println("Serwer działa");
        ServerSocket listener = new ServerSocket(22222);
        //Gwiazda_serwera gs = new Gwiazda_serwera(liczba_graczy+liczba_botow);
        System.out.println("done");
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {
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
                    if ( wyjscia.size() == Integer.parseInt(liczba_graczy) ){
                        for (int i = 0; i < wyjscia.size(); i++) {
                            wyjscia.get(i).println(Integer.parseInt(liczba_graczy)+Integer.parseInt(liczba_botow));
                            wyjscia.get(i).println(kolory[i]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String input = null;

                for (int i = 0; i < wyjscia.size(); i++) {
                    try {
                        input = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("dostałem "+input);
                }
                    System.out.println("serwer wysyla start");
                    int j = 0;
                    for (int i = 0; i < wyjscia.size(); i++) {
                        wyjscia.get(i).println("Start");
                        System.out.println("serwer wysyla start");
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("serwer wysyla ustaw koloe");
                        wyjscia.get(i).println("ustaw kolor");
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        wyjscia.get(i).println(kolory[j]);
                        System.out.println("serwer wysyla kolejke");
                    }
                    j++;
                    while (true) {
                         input = null;
                        try {
                            input = in.readLine();
                            //if ( input.equals("")) continue;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < wyjscia.size(); i++) {
                            wyjscia.get(i).println(input);
                            wyjscia.get(i).println("ustaw_kolor");
                            wyjscia.get(i).println(kolory[j]);
                        }
                        System.out.println("serwer wysyla " + kolory[j]);
                        if (j + 1 == wyjscia.size()) j = 0;
                        else j++;
                    }
                }
            }
        }
    }

