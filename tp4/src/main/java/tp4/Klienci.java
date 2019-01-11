package tp4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Klienci {
    static String nazwa_klienta;
    public Klienci ( String a) {
        nazwa_klienta = a;
        System.out.println("Stworzono klienta " + nazwa_klienta);
    }
    public static void main(String[] arg) throws IOException {
        //try {
            Socket socketConnection = new Socket("127.0.0.1", 2222);
            System.out.println("Stworzono klienta " + nazwa_klienta);
           // DataOutputStream outToServer = new ataOutputStream(socketConnection.getOutputStream());
          //  String SQL="I  am  client 1";
           // outToServer.writeUTF(SQL);
        //} catch (Exception e) {System.out.println(e); }
    }
}