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
    private int numerRuchu = 1;
    int przyciskRuchuId = -1;
    int ostatnioKlikniety = -1;
    boolean pierwszyRuch = true;

    private int liczbaGraczy;
    private int liczbaBotow;
    Serwer serwer;
    private double x_1, x_2, y_1, y_2;
    private int indexA, indexB;
    private Gwiazda_serwera gws;

    int liczbaWygranych = 0;

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
    public synchronized boolean PrzedlegalMove(Player player, String command) {
        Button pierwszyZamiana = gws.wszystkie_przyciski[0];
        Button drugiZamiana = gws.wszystkie_przyciski[0];
        Button pomiedzy1 = new Button();
        Button pomiedzy2 = new Button();
        int i1 =0;int  i2 =0;

        int RED=0,GREEN=0,BLUE=0,ROYALBLUE=0,YELLOW=0,BROWN=0;

        if (player == currentPlayer) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(command);
            List<Integer> ints = new ArrayList<>();

            while (m.find()) {
                String i = m.group();
                ints.add(Integer.valueOf(i));
            }

            i1 = ints.get(0);
            i2 = ints.get(1);
        }
        if ( player.kolor.equals("RED")) {
            if ( i1 == 174 || i1 == 175 || i1 == 176 || i1 == 177|| i1 == 188|| i1 == 189|| i1 == 190|| i1 == 201|| i1 == 202|| i1 == 215) {
                return false;
            }
            else if ( i2 == 174 || i2 == 175 || i2 == 176 || i2 == 177|| i2 == 188|| i2 == 189|| i2 == 190|| i2 == 201|| i2 == 202|| i2 == 215) {
                RED++;
                return true;
            }
            if ( RED == 10 ) {
                System.out.println("Grę wygrał gracz czerwony");
                liczbaWygranych++;
                return true;
            }
        }
        else if ( player.kolor.equals("BLUE")){

            if ( i1 == 119 || i1 == 132 || i1 == 133 || i1 == 144 || i1 == 145 || i1 == 146 || i1 == 157 || i1 == 158 || i1 == 159 || i1 == 160) {
                return false;
            }
            else if ( i2 == 119 || i2 == 132 || i2 == 133 || i2 == 144 || i2 == 145 || i2 == 146 || i2 == 157 || i2 == 158 || i2 == 159 || i2 == 160) {
                BLUE++;
                return true;
            }
            if ( BLUE == 10 ) {
                System.out.println("Grę wygrał gracz ciemnoniebieski");
                liczbaWygranych++;
                return true;
            }
        }
        else if ( player.kolor.equals("YELLOW")){

            if ( i1 == 128 || i1 == 141 || i1 == 153 || i1 == 166 || i1 == 167 || i1 == 154 || i1 == 142 || i1 == 168 || i1 == 155 || i1 == 169) {
                return false;
            }
            else if ( i2 == 128 || i2 == 141 || i2 == 153 || i2 == 166 || i2 == 167 || i2 == 154 || i2 == 142 || i2 == 168 || i2 == 155 || i2 == 169) {
                YELLOW++;
                return true;
            }
            if ( YELLOW == 10 ) {
                System.out.println("Grę wygrał gracz żółty");
                liczbaWygranych++;
                return true;
            }
        }
        else if ( player.kolor.equals("GREEN")) {
            if ( i1 == 62 || i1 == 63 || i1 == 64 || i1 == 65 || i1 == 75 || i1 == 76 || i1 == 77 || i1 == 89 || i1 == 90 || i1 == 102) {
                return false;
            }
            else if ( i2 == 62 || i2 == 63 || i2 == 64 || i2 == 65 || i2 == 75 || i2 == 76 || i2 == 77 || i2 == 89 || i2 == 90 || i2 == 102) {
                GREEN++;
                return true;
            }
            if ( GREEN == 10 ) {
                System.out.println("Grę wygrał gracz zielony");
                liczbaWygranych++;
                return true;
            }
        }
        else if ( player.kolor.equals("BROWN")) {
            if ( i1 == 7 || i1 == 19 || i1 == 20 || i1 == 32 || i1 == 33 || i1 == 34 || i1 == 44 || i1 == 45 || i1 == 46 || i1 == 47) {
                return false;
            }
            else if ( i2 == 7 || i2 == 19 || i2 == 20 || i2 == 32 || i2 == 33 || i2 == 34 || i2 == 44 || i2 == 45 || i2 == 46 || i2 == 47) {
                BROWN++;
                return true;
            }
            if ( BROWN == 10 ) {
                System.out.println("Grę wygrał gracz brązowy");
                liczbaWygranych++;
                return true;
            }
        }
        else if ( player.kolor.equals("ROYALBLUE")) {

            if ( i1 == 53 || i1 == 54 || i1 == 55 || i1 == 56 || i1 == 66 || i1 == 67 || i1 == 68 || i1 == 80 || i1 == 81 || i1 == 93) {
                return false;
            }
            else if ( i2 == 53 || i2 == 54 || i2 == 55 || i2 == 56 || i2 == 66 || i2 == 67 || i2 == 68 || i2 == 80 || i2 == 81 || i2 == 93) {
                ROYALBLUE++;
                return true;
            }
            if ( ROYALBLUE == 10 ) {
                System.out.println("Grę wygrał gracz królewskoniebieski xD");
                liczbaWygranych++;
                return true;
            }
        }

        if ( liczbaWygranych == (liczbaGraczy + liczbaBotow - 1)) {
            System.out.println("Zakonczono");
        }
        return true;
    }


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


            if (pierwszyRuch) {
                przyciskRuchuId = idDrugiego;
            }

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

//            System.out.println(player.kolor + " player");

            String pionekAktualnegoGracza = "-fx-background-radius: 500em; -fx-background-color: " + player.kolor + "; -fx-text-fill: " + player.kolor + "; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
            String pusty ="-fx-background-radius: 500em; -fx-background-color: SALMON; -fx-text-fill: SALMON; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//            System.out.println(pionekAktualnegoGracza);
//            System.out.println(pierwszyZamiana.getStyle());
//            System.out.println(drugiZamiana.getStyle());
//            System.out.println("A: " + pierwszyZamiana.getText() + " B: " + drugiZamiana.getText());
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

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

            System.out.println("------------------------------------");
            System.out.println("NR RUCHU: " + numerRuchu + "  BUTTON: " + przyciskRuchuId);

            if((pierwszyZamiana.getStyle().equals(pionekAktualnegoGracza)))//ruch swoim pionkiem
            {
                if (drugiZamiana.getStyle().equals(pusty))//ruch na wolne pole
                {
                    if(odl < 81.0)
                    {
                        if (pierwszyRuch) {
                            pierwszyRuch = false;
                            isValid = true;
                            currentPlayer = nastepnyGracz();
                            System.out.println("PIERWSZY IF odl < 81 " + isValid);
                        }
                    }

                    else if((odl>119)&&(odl<140))
                    {
                        if(odl==120.0) // przeskok poziomy
                        {
                            String co_pomiedzy = pomiedzy1.getStyle();

                            if((!co_pomiedzy.equals(pusty))&&x_1!=x_2)
                            {
                                if (pierwszyRuch) {
                                    pierwszyRuch = false;
                                    numerRuchu++;
                                    przyciskRuchuId = idPierwszego;
                                    ostatnioKlikniety = idDrugiego;
                                    isValid = true;
                                } else {
                                    if (idPierwszego == ostatnioKlikniety) {
                                        numerRuchu++;
                                        isValid = true;
                                        ostatnioKlikniety = idDrugiego;
                                    }
                                }
                            }
                        }
                        else if((odl>133)&&(odl<135))//przeskok skosny
                        {
                            String co_pomiedzy = pomiedzy2.getStyle();
                            if(!co_pomiedzy.equals(pusty))
                            {
                                if (pierwszyRuch) {
                                    pierwszyRuch = false;
                                    numerRuchu++;
                                    przyciskRuchuId = idPierwszego;
                                    ostatnioKlikniety = idDrugiego;
                                    isValid = true;
                                } else {
                                    if (idPierwszego == ostatnioKlikniety) {
                                        przyciskRuchuId = idPierwszego;
                                        numerRuchu++;
                                        ostatnioKlikniety = idDrugiego;
                                        isValid = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // TODO: sprawdzanie czy poprawny ruch
//            currentPlayer = serwer.nastepnyGracz(currentPlayer);
//            return false;
            System.out.println("PO WSZYSTKIM" + isValid + " " + numerRuchu + " " + przyciskRuchuId + " " + idPierwszego);

            System.out.println("NR RUCHU: " + numerRuchu + " BUTTON: " + przyciskRuchuId);

            if (isValid) {
                Platform.runLater(() -> gws.ruch(String.valueOf(idPierwszego), String.valueOf(idDrugiego)));
            }
        }

        return isValid;
    }

    synchronized boolean isCurrentPlayer(Player player) {
        return currentPlayer.equals(player);
    }

    synchronized Player nastepnyGracz() {
        Game.Player gracz = serwer.gracze.get((serwer.gracze.indexOf(currentPlayer) + 1)% serwer.liczbaWszystkich);
        przyciskRuchuId = -1;
        numerRuchu = 1;
        pierwszyRuch = true;

        System.out.println("Zmiana gracz z : " + currentPlayer.kolor + " na: " + gracz.kolor);

        while (gracz instanceof Bot) {
            Player x = gracz;
            gracz = serwer.gracze.get((serwer.gracze.indexOf(gracz) + 1)% serwer.liczbaWszystkich);
            serwer.wyslijWszystkim("SKIP " + x.kolor);
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
//
                    if (command.startsWith("MOVE")) {
                        if ( PrzedlegalMove(this, command) ) {
                            if (legalMove(this, command)) { //trzeba wyslac wskaznik do gwiazdy !!!!!
                                serwer.wyslijWszystkim(command); // Wysylamy komende z ruchem do innych (można to zmodyfikowac w razie potrzeb)
                                serwer.wyslijWszystkim(getCurrentPlayerMessage()); // Wysylamy komende ze zmianą gracza, który ma ruch
                            }
                        }
                    }
                    // Sprawdzanie komend
                    // Komenda z ruchem "MOVE nr_jednego_przycisku nr_durgiego_przycisku"
                    /*
                    if (command.startsWith("MOVE")) {
                        // Sprawdzanie czy ruch jest poprawny
                        if (legalMove(this, command)) { //trzeba wyslac wskaznik do gwiazdy !!!!!
                            serwer.wyslijWszystkim(command); // Wysylamy komende z ruchem do innych (można to zmodyfikowac w razie potrzeb)
                            serwer.wyslijWszystkim(getCurrentPlayerMessage()); // Wysylamy komende ze zmianą gracza, który ma ruch
                        }
                    }
                    */
                    // Komenda na pominiecie ruchu "SKIP"
                    if (command.startsWith("SKIP")) {
                        if (isCurrentPlayer(this)) {
                            currentPlayer = nastepnyGracz();
                            serwer.wyslijWszystkim(getCurrentPlayerMessage());
                            serwer.wyslijWszystkim(getSkipMessage());
                            //NumerRuchu=0;
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