package tp4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Multi extends Thread {
    private Socket s;
    private DataInputStream infromClient;
    Multi (Socket s) throws IOException, InterruptedException {

        this.s = s;
        infromClient = new DataInputStream(s.getInputStream());
    }
    public void run(){
        String SQL= "";
        try {
            SQL = infromClient.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Query: " + SQL);
        try {
            System.out.println("Socket Closing");
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Serwer {

    public  Serwer () throws IOException, InterruptedException {

        //while (true) {

           ServerSocket nowy_serwer = new ServerSocket(2222);
            System.out.println("Serwer dziala");
           // Socket gniazdo = nowy_serwer.accept();
           // Multi watki = new Multi(gniazdo);
            //watki.start();

            //Thread.sleep(2000);

           //nowy_serwer.close();
       // }




    }
}

//test comittowania z drugiego komputera