package Serwer;

import javafx.application.Platform;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Klasa Game trzyma informacje ogólne na temat gry
 * Między innymi ma informację o graczu, który aktualnie ma ruch
 */
class Game {
    Player currentPlayer;
    int numerRuchu;
    int przyciskRuchuId;

    private int liczbaGraczy;
    private int liczbaBotow;
    Serwer serwer;
    private double x_1, x_2, y_1, y_2;
    private int indexA, indexB;
    private Gwiazda_serwera gws;

    Game(int liczbaGraczy, int liczbaBotow, Serwer serwer) {
        this.liczbaGraczy = liczbaGraczy;
        this.liczbaBotow = liczbaBotow;
        this.serwer = serwer;
        Platform.runLater(() -> {
            gws = new Gwiazda_serwera(liczbaGraczy + liczbaBotow);
        });
    }
/*
    //cos nie dziala ta metoda
    void ruchSerwerowy(int rs1 ,int rs2,Gwiazda_serwera gws)
    {
        Button temp = new Button();
        temp=gws.wszystkie_przyciski[rs1];
        gws.wszystkie_przyciski[rs1]=gws.wszystkie_przyciski[rs2];
        gws.wszystkie_przyciski[rs2]=temp;
    }
*/
    /**
     * Metoda legalMove sprawdza czy ruch może zostać wykonany
     * Jeżeli gracz wykonujący ruch ma prawo ruchu oraz jeżeli ruch przejdzie walidacje
     * Aktualny gracz zmieniany jest na kolejnego i zwracane jest TRUE
     * W przeciwnym wypadku FALSE
     */
    public synchronized boolean legalMove(Player player, String command) {
        Button pierwszyZamiana = gws.wszystkie_przyciski[0];
        Button drugiZamiana = gws.wszystkie_przyciski[0];
        Button pomiedzy1 = new Button();
        Button pomiedzy2 = new Button();



        boolean isValid = false;
        if (player == currentPlayer) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(command);
            List<Integer> ints = new ArrayList<>();

            while (m.find()) {
                String i = m.group();
                ints.add(Integer.valueOf(i));
            }

            int idPierwszego = ints.get(0);
            int idDrugiego = ints.get(1);
            System.out.println(idPierwszego);
            System.out.println(idDrugiego);
            //Dorobic zamiane buttonow na w gwiezdzie serwerowej

            for(int i=0; i < gws.wszystkie_przyciski.length; i++)   //szukanie przyciskow do zamiany
            {

                String x = gws.wszystkie_przyciski[i].getText();
                String chwilowa = String.valueOf(idPierwszego);
                String chwilowa2 = String.valueOf(idDrugiego);

                if(chwilowa.equals(x))
                {
                    pierwszyZamiana = gws.wszystkie_przyciski[i];
                    indexA=i;
                }
                if(chwilowa2.equals(x))
                {
                    drugiZamiana = gws.wszystkie_przyciski[i];
                    indexB=i;
                }

            }

            System.out.println(player.kolor + "player");

            String pionekAktualnegoGracza = "-fx-background-radius: 500em; -fx-background-color: " + player.kolor + "; -fx-text-fill: " + player.kolor + "; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
            String pusty ="-fx-background-radius: 500em; -fx-background-color: SALMON; -fx-text-fill: SALMON; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println(pionekAktualnegoGracza);
            System.out.println(pierwszyZamiana.getStyle());
            System.out.println(drugiZamiana.getStyle());
            System.out.println("A: " + pierwszyZamiana.getText() + " B: " + drugiZamiana.getText());
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            x_1 = pierwszyZamiana.getLayoutX();
            y_1 = pierwszyZamiana.getLayoutY();
            x_2 = drugiZamiana.getLayoutX();
            y_2 = drugiZamiana.getLayoutY();
            double odl=sqrt(pow((x_1-x_2),2.0)+pow(y_1-y_2,2.0));
            pomiedzy1=gws.wszystkie_przyciski[1];


            //szukanie przyciskow pomiedzy
            for(int i=0;i<gws.wszystkie_przyciski.length;i++)
            {
                if((gws.wszystkie_przyciski[i].getLayoutX()==((x_1+x_2)/2))&&(gws.wszystkie_przyciski[i].getLayoutY()==y_1)&&(gws.wszystkie_przyciski[i].getLayoutY()==y_2)) {
                    pomiedzy1 = gws.wszystkie_przyciski[i];
                }
                double srednia_x=(x_1+x_2)/2;
                double srednia_y=(y_1+y_2)/2;
                if((gws.wszystkie_przyciski[i].getLayoutX()>srednia_x-1)&&(gws.wszystkie_przyciski[i].getLayoutX()<srednia_x+1)&&(gws.wszystkie_przyciski[i].getLayoutY()>srednia_y-1)&&(gws.wszystkie_przyciski[i].getLayoutY()<srednia_y+1)) {
                    pomiedzy2=gws.wszystkie_przyciski[i];
                }
            }


            if((pierwszyZamiana.getStyle().equals(pionekAktualnegoGracza)))//ruch swoim pionkiem
            {
                if (drugiZamiana.getStyle().equals(pusty))//ruch na wolne pole
                {
                    if(odl<81.0)
                    {
//                        Button temp = new Button();
//                        temp=gws.wszystkie_przyciski[rs1];
//                        gws.wszystkie_przyciski[rs1]=gws.wszystkie_przyciski[rs2];
//                        gws.wszystkie_przyciski[rs2]=temp;
                        currentPlayer = nastepnyGracz();

                        //Serwer.Serwer.Gwiazda_serwera.ruchSerwerowy(rs1,rs2,gws);
                        //ruchSerwerowy(rs1,rs2,gws);
//                        return true;
                        isValid = true;
                    }

                    else if((odl>119)&&(odl<140))
                    {
                        //TO DO: skok gora dol nad polem bez przycisku trzeba zablokowac
                        if(odl==120.0) // przeskok poziomy
                        {
                            String co_pomiedzy =pomiedzy1.getStyle();

                            if((!co_pomiedzy.equals(pusty))&&x_1!=x_2)
                            {
//                                Button temp = new Button();
//                                temp=gws.wszystkie_przyciski[rs1];
//                                gws.wszystkie_przyciski[rs1]=gws.wszystkie_przyciski[rs2];
//                                gws.wszystkie_przyciski[rs2]=temp;
//                                currentPlayer = serwer.nastepnyGracz(currentPlayer);
//                                return true;
                                isValid = true;
                            }
                        }
                        else if((odl>133)&&(odl<135))//przeskok skosny
                        {
                            String co_pomiedzy =pomiedzy2.getStyle();
                            if(!co_pomiedzy.equals(pusty))
                            {
//                                Button temp = new Button();
//                                temp=gws.wszystkie_przyciski[rs1];
//                                gws.wszystkie_przyciski[rs1]=gws.wszystkie_przyciski[rs2];
//                                gws.wszystkie_przyciski[rs2]=temp;
//                                currentPlayer = serwer.nastepnyGracz(currentPlayer);
//                                return true;
                                isValid = true;
                            }

                        }
                    }


                }

//                return false;
            }

            // TODO: sprawdzanie czy poprawny ruch
//            currentPlayer = serwer.nastepnyGracz(currentPlayer);
//            return false;
            if (isValid) {
                Platform.runLater(() -> gws.ruch(String.valueOf(idPierwszego), String.valueOf(idDrugiego)));
            }
        }

        return isValid;
    }

    synchronized boolean isCurrentPlayer(Player player) {
        return currentPlayer.equals(player);
    }

    Player nastepnyGracz() {
        Game.Player gracz = serwer.gracze.get((serwer.gracze.indexOf(currentPlayer) + 1)% serwer.liczbaWszystkich);
        przyciskRuchuId = -1;
        numerRuchu = 0;
        System.out.println("Zmiana gracz z : " + currentPlayer.kolor + " na: " + gracz.kolor);

        while (gracz instanceof Bot) {
            Player x = gracz;
            gracz = serwer.gracze.get((serwer.gracze.indexOf(gracz) + 1)% serwer.liczbaWszystkich);
            serwer.wyslijWszystkim("SKIP " + x);
            System.out.println("Zmiana gracz z : " + x.kolor + " na: " + gracz.kolor);
        }
        return gracz;
    }

    //sprawdzanie czy koniec gry
    {

    }
    /**
     * Klasa Player to wątek z połączonym jednym graczem (jeden Player = jeden Klient)
     * W konstruktorze odbierana jest nazwa użytkownika, a następnie wysyłane jest info z ustawieniami gry
     */

    class Player extends Thread {
        String nazwa;
        String kolor;
        Socket socket;
        BufferedReader input;
        PrintWriter output;

        Player(String kolor) {
            this.kolor = kolor;
        }

        Player(Socket socket, String kolor) {
            this.socket = socket;
            this.kolor = kolor;

            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);

                nazwa = input.readLine();
                output.println("GAME_SETTINGS " + nazwa + " " + (liczbaGraczy + liczbaBotow) + " " + liczbaBotow + " " + kolor);

                System.out.println("Gracz " + nazwa + " dołączył do serwera i otrzymał " + kolor + " kolor");
            } catch (IOException e) {
                System.out.println("Gracz nie jest polaczony: " + e);
            }
        }
        Gwiazda_serwera gws;
        /**
         * Metoda wątku, uruchamiana w klasie Serwer metodą .start()
         * Znajduje się tutaj główna pętla, która cały czas zczytuje wiadomości od klienta
         * Żeby uprościć komunikacje do wysyłania wiadomości jest dodakowa metoda z serwera .wyslijWszystkim()
         * ponieważ wysyłając tutaj wiadomość przez output.println() dostanie ją tylko jeden klient, który wysłał swoją wiadomość
         */
        public void run() {
            try {
                // Te dwie poniżej wiadomości dostanie każdy klient przy starcie
                output.println("START_GAME");
                output.println(getCurrentPlayerMessage());

                while (true) {
                    String command = input.readLine(); // czekanie na komende
                    System.out.println("Od: " + nazwa + " " + kolor + " - wiadomosc: " + command);

                    // Sprawdzanie komend
                    // Komenda z ruchem "MOVE nr_jednego_przycisku nr_durgiego_przycisku"
                    if (command.startsWith("MOVE")) {
                        // Sprawdzanie czy ruch jest poprawny
                        if (legalMove(this, command)) { //trzeba wyslac wskaznik do gwiazdy !!!!!
                            serwer.wyslijWszystkim(command); // Wysylamy komende z ruchem do innych (można to zmodyfikowac w razie potrzeb)
                            serwer.wyslijWszystkim(getCurrentPlayerMessage()); // Wysylamy komende ze zmianą gracza, który ma ruch
                        }
                    }
                    // Komenda na pominiecie ruchu "SKIP"
                    if (command.startsWith("SKIP")) {
                        if (isCurrentPlayer(this)) {
                            currentPlayer = nastepnyGracz();
                            serwer.wyslijWszystkim(getCurrentPlayerMessage());
                            serwer.wyslijWszystkim(getSkipMessage());
                        }
                    }
                    // Tego nie obsługuje na kliencie, ale można dodać, wtedy można powiedzieć, że zakończy się działanie Playera
                    if (command.startsWith("QUIT")) {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("Gracz nie jest polaczony: " + e);
            } finally {
                try {socket.close();} catch (IOException e) {}
            }
        }

        // Żeby nie pisać ręcznie za każdym razem komend to potworzyłem klasy, które zwracają tekst do wysłania
        String sendInfo(String msg) {
            return "INFO " + msg;
        }
        String getCurrentPlayerMessage() {
            return "CURRENT_PLAYER " + currentPlayer.kolor;
        }
        String getSkipMessage() {
            return "SKIP " + currentPlayer.kolor;
        }

        void sendMsg(String msg) {
            output.println(msg);
        }
    }


    class Bot extends Player{
        String kolor;

        Bot(String kolor) {
            super(kolor);
        }

        public void start() {
            if (currentPlayer.equals(this)) {
                currentPlayer = nastepnyGracz();
                serwer.wyslijWszystkim(getCurrentPlayerMessage());
            }
        }
    }
}