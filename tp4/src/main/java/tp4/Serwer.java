package tp4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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