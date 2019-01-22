package tp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Serwer{

    //private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private static List<PrintWriter> wyjscia = new ArrayList<PrintWriter>();
    public static void main(String[] args) throws Exception {

        ServerSocket listener = new ServerSocket(22222);
        try {
            while (true) {
                new Handler(listener.accept()).start();
                System.out.println("1");
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
                System.out.println("2");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("dodaje wyjscie");
                wyjscia.add(out);
                if ( wyjscia.size() == 1) {
                    out.println("ruch");
                }
                else
                    out.println("czekaj");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                String input = null;
                try {
                    input = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // for ( int i = 0; i< wyjscia.size(); i++) {
                    wyjscia.get(1).println(input);
                    wyjscia.get(0).println(input);
                //}
            }
            }
        }
    }
}
