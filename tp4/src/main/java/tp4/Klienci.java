package tp4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Klienci {
    static String nazwa_klienta;
    public Klienci ( String a) throws IOException {
        //Socket socketConnection = new Socket("127.0.0.1", 11111);
        nazwa_klienta = a;
        System.out.println("Stworzono gracza: " + nazwa_klienta);
        start();
    }
    public static void start() throws IOException {
        //try {
            Gwiazda plansza =  new Gwiazda();
            //Socket socketConnection = new Socket("127.0.0.1", 11111);
           // DataOutputStream outToServer = new ataOutputStream(socketConnection.getOutputStream());
          //  String SQL="I  am  client 1";
           // outToServer.writeUTF(SQL);
        //} catch (Exception e) {System.out.println(e); }
    }
}