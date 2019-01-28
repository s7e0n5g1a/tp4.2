package Serwer;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Serwer extends Application {
    static final String[] KOLORY = {"RED", "BLUE", "YELLOW", "GREEN", "BROWN", "ROYALBLUE"};

    List<Game.Player> gracze = new ArrayList<>();
    private int liczbaGraczy, liczbaBotow;
    int liczbaWszystkich;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        new LiczbaGraczy(this);
    }

    void ustawDane(int a, int b) {
        liczbaGraczy = a;
        liczbaBotow = b;
        liczbaWszystkich = a + b;

        System.out.println("Liczba graczy: " + a);
        System.out.println("Liczba botów: " + b);

        // Tutaj metoda rozpocznijGre() jest opakowana w nowy wątek i uruchamiana
        Thread gra = new Thread(this::rozpocznijGre);
        gra.start();
    }

    void rozpocznijGre() {
        try {
            ServerSocket listener = new ServerSocket(22222);
            System.out.println("Serwer włączony - nasłuchuje na graczy");

            // Tworzona jest nowa instancja gry
            Game game = new Game(liczbaGraczy, liczbaBotow, this);

            for (int i = 0; i < liczbaGraczy; i++) {
                // Tutaj for jest blokowany przez listener.accept() dopóki każdy gracz się nie połączy
                // Kazdy kolejny gracz dostaje swój kolor według kolejności
                gracze.add(game.new Player(listener.accept(), KOLORY[i]));

                wyslijWszystkim("INFO Oczekiwanie na " + (liczbaGraczy - 1) + " graczy");
            }

            for (int i = liczbaGraczy; i < liczbaBotow + liczbaGraczy; i++) {
                gracze.add(game.new Bot(KOLORY[i]));
            }


            // Losowanie i ustawienie gracza, który rozpocznie
            Random rand = new Random();
            game.currentPlayer = gracze.get(rand.nextInt(gracze.size()));

            // Rozpoczęcie wszystkich graczy (odpala się metoda .run() w graczu
            for (Game.Player gracz : gracze) {
                gracz.start();
            }

            System.out.println("Wszyscy gracze połączeni - gra rozpoczęta");
            System.out.println("-----------------------------------------");
        } catch (IOException e) {
            System.out.println("Problem z serwerem: " + e.getMessage());
        }
    }

    void wyslijWszystkim(String msg) {
        System.out.println("DO WSZYSTKICH: " + msg);
        for (Game.Player gracz : gracze) {
            if (!(gracz instanceof Game.Bot)) {
                gracz.sendMsg(msg);
            }
        }
    }

//    Game.Player nastepnyGracz(Game.Player aktualnyGracz, Game game) {
//        Game.Player gracz = gracze.get((gracze.indexOf(aktualnyGracz) + 1)%liczbaWszystkich);
//        game.przyciskRuchuId = -1;
//        game.numerRuchu = 0;
//        System.out.println("Zmiana gracz z : " + aktualnyGracz.kolor + " na: " + gracz.kolor);
//        return gracz;
//    }

}

