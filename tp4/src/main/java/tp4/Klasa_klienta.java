package tp4;
import java.net.*;
import java.io.*;

public class Klasa_klienta {
    private Socket klientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        klientSocket = new Socket(ip, port);
        out = new PrintWriter(klientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(klientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        klientSocket.close();
    }

}
