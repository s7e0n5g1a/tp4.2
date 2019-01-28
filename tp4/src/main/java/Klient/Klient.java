package Klient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Klient extends Application {
    private ClientSocket clientSocket = new ClientSocket();
    private OknoDolaczania oknoDolaczania;
    private Gra gra;

    String nazwa;
    int liczbaGraczy;
    int liczbaBotow;
    String kolor;
    String aktualnyGracz;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        clientSocket.start("127.0.0.1", 22222);
        oknoDolaczania = new OknoDolaczania(this);
    }

    /**
     * Metoda polacz() odpala się po kliknieciu w przycisk w oknie podawania nazwy
     * Wysyła ona na serwer wiadomość ze swoją nazwą
     * (swoją drogą rozpoznawanie gracza, kto jest kim, jest po kolorze nie nazwie,
     * żeby nie trzeba było sprawdzać unikalności nazwy)
     */
    void polacz(String nazwa) {
        clientSocket.sendMessage(nazwa);

        // Tworzy nowy wątek, który pozwala na nasłuchiwanie z serwera bez crashowania okna
        Thread czekajNaGraczy = new Thread(this::czekajNaGraczy);
        czekajNaGraczy.start();
    }

    /**
     * Uruchamia się w nowym wątku i wykonuje wiadomosci z serwera
     * do czasu rozpoczecia gry komenda "START_GAME"
     */
    void czekajNaGraczy() {
        boolean czeka = true;
        while (czeka) {
            String msg = clientSocket.getMessage();
            List<String> args = splitMsg(msg);

            if (msg.startsWith("GAME_SETTINGS")) {
                this.nazwa = args.get(0);
                this.liczbaGraczy = Integer.parseInt(args.get(1));
                this.liczbaBotow = Integer.parseInt(args.get(2));
                this.kolor = args.get(3);
            }
            if (msg.startsWith("INFO")) {
                // Wyświetla informacje z serwera, co ciekawe nie potrzebuje Platform.runLater,
                // żeby zmieniać tekst w okienku (nie wiem czemu xD)
                oknoDolaczania.wyswietlInfo(String.join(" ", args));
            }
            if (msg.startsWith("START_GAME")) {
                czeka = false;

                // Z racji tego, że czekajNaGraczy() działa w osobnym wątku nie mamy możliwosci
                // zarządzania oknami javaFX bezpośrednio, ale można to dzięki
                // Platform.runLater(), które powoduje wywołanie tego co w środku w wątku javaFX
                Platform.runLater(() -> oknoDolaczania.close());
                Platform.runLater(() -> this.gra = new Gra(this));

                // Odpala nowy wątek z metodą która działa tak jak czekajNaGraczy()
                // i służy do komunikacji z serwerem już po rozpoczęciu gry
                Thread graj = new Thread(this::graj);
                graj.start();
            }
        }
    }

    /**
     * Metoda zczytująca wiadomości / komendy z serwera i wykonująca na ich podstawie jakieś akcje
     * Jeżeli chcemy zrobić jakieś działanie na oknach javaFX to trzeba opakować je w
     * Platform.runLater(() -> { jakieś_super_programy })
     */
    void graj() {
        while (true) {
            String msg = clientSocket.getMessage();
            List<String> args = splitMsg(msg);

            // Ustawienie aktualnego gracza
            if(msg.startsWith("CURRENT_PLAYER")) {
                aktualnyGracz = args.get(0);
                Platform.runLater(() -> gra.ustawAktualnegoGracza(aktualnyGracz, aktualnyGracz.equals(kolor)));
            }

            // Wykonanie ruchu
            if(msg.startsWith("MOVE")) {
                Platform.runLater(() -> gra.ruch(args.get(0), args.get(1)));
            }
        }
    }

    List<String> splitMsg(String msg) {
        System.out.println("SPLIT MSG - " + msg);
        List<String> splited = new ArrayList<>(Arrays.asList(msg.split("\\s+"))); // splituje po spacjach nawet jak są wielokrotne to traktuje jak pojedyncze
        splited.remove(0); // usuwa pierwszy argument zawierający komende np. "MOVE"
        return splited;
    }

    /**
     * Wysyła wiadomość do serwera z informacją jakie dwa przyciski będą zamieniane
     */
    void wykonajRuch(ArrayList<Integer> numeryDoZamiany) {
        clientSocket.sendMessage("MOVE " + numeryDoZamiany.get(0) + " " + numeryDoZamiany.get(1));
    }

}