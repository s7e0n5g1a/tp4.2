package tp4;
import java.net.*;
import java.io.*;
public class Klasa_serwera {
    private ServerSocket serwerSocket;
    private Socket klientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void zacznij(int port) throws IOException {
        serwerSocket = new ServerSocket(port);
        klientSocket = serwerSocket.accept();
        out = new PrintWriter(klientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(klientSocket.getInputStream()));
        String greeting = in.readLine();
        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }

    public void zatrzymaj() throws IOException {
        in.close();
        out.close();
        klientSocket.close();
        serwerSocket.close();
    }
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        Klasa_klienta klient1 = new Klasa_klienta();
        klient1.startConnection("127.0.0.1", 6666);
        String response = klient1.sendMessage("hello server");
    }
}



