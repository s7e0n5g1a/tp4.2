package tp4;

import java.io.DataOutputStream;
import java.net.Socket;

public class Klient {
    public static void main(String[] arg) {
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            String SQL="I  am  client 1";
            outToServer.writeUTF(SQL);
        } catch (Exception e) {System.out.println(e); }
    }
}