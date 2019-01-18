package tp4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


class Multi extends Thread{

    private Socket s=null;
    DataInputStream infromClient;

    public Multi(Socket s) throws IOException{
        this.s=s;
        infromClient = new DataInputStream(s.getInputStream());

        String SQL=new String();
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
        //System.out.println("Serwer otrzymał od gracza " + napis_od_gracza);
      //  try {
       //     System.out.println("Socket Closing");
       //     s.close();
      //  } catch (IOException ex) {
       //     Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
      //  }
    }

public class Serwer {

    public static void main(String args[]) throws IOException, InterruptedException{

        while(true){
            ServerSocket ss=new ServerSocket(11111);
            System.out.println("Server is Awaiting");
            Socket s=ss.accept();
            Multi t=new Multi(s);
            t.start();

            Thread.sleep(2000);
            ss.close();
        }




    }
}/*
    public Button[] zamien_miejscami (Button [] zamien_przyciski) {

        if(a !=0&& b!=0) {
            Walidacja w = new Walidacja(a, b, lg, wszystkie_przyciski);
            x_1 = zamien_przyciski[0].getLayoutX();
            y_1 = zamien_przyciski[0].getLayoutY();
            x_2 = zamien_przyciski[1].getLayoutX();
            y_2 = zamien_przyciski[1].getLayoutY();
            zamien_przyciski[0].setLayoutX(x_2);
            zamien_przyciski[0].setLayoutY(y_2);
            zamien_przyciski[1].setLayoutX(x_1);
            zamien_przyciski[1].setLayoutY(y_1);
        }
        else {}
        klikacz = 0;
        return zamien_przyciski;
    }
*/