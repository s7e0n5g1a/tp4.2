package Klient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Dodakowa klasa do obsługi socketów
public class ClientSocket {
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;

    public void start(String ip, int port) {
        try {
            client = new Socket(ip, port);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("ClientSocket: Polaczono");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void sendMessage(String msg) {
        System.out.println("ClientSocket: Wysylanie wiadomosci - " + msg);
        out.println(msg);
        System.out.println("ClientSocket: Wyslano wiadomosc - " + msg);
    }

    public String getMessage() {
        try {
            System.out.println("ClientSocket: Oczekiwanie na wiadomosc");
            String resp = in.readLine();
            System.out.println("ClientSocket: Odebrano wiadomosc - " + resp);
            return resp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void stop () throws IOException {
        in.close();
        out.close();
        client.close();
    }
}
