package tp4;

import java.io.DataOutputStream;
import java.net.Socket;


public class Klienci {
    public Klienci ( String a) {
        String nazwa_klienta = a;
        System.out.println("Stworzono klienta " +a );
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);

            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());

            String SQL="I  am  client 1";
            outToServer.writeUTF(SQL);

        } catch (Exception e) {System.out.println(e); }
    }
}