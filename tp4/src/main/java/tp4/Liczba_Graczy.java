package tp4;

public class Liczba_Graczy {
    public Liczba_Graczy (int l) throws WyjatekException {
        if (l != 1 && l != 2 && l!=3 && l != 4 && l!= 6) {
            throw new WyjatekException("niepoprawna liczba graczy");
        }
    }
}
