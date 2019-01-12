package tp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serwer {

    private static String localhost = "127.0.0.1";
    private static int port = 2222;
    ServerSocket serwer = new ServerSocket(port);

    public Serwer() throws IOException {
    }


    public static void main(String[] args) throws IOException {
        String nazwa_serwera ="localhost";
        ServerSocket serwer = new ServerSocket(port);
        System.out.println("Serwer dziala");
            while (true) {
                Socket socket = serwer.accept();
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String answer = input.readLine();
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                } finally {
                   // socket.close();
                    System.out.println("dupa");
                }
            }
    }
    public int zwroc_port () {
        return  port;
    }
    public String zwroc_localhost () {
        return localhost;
    }
    public void zamknij () throws IOException {
        serwer.close();
    }
}