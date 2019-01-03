package tp4;

public class Liczba_Graczy {
    public Liczba_Graczy (String l) throws WyjatekException {
        if ((!"2".equals(l))&& (!"3".equals(l)) && (!"4".equals(l)) && (!"6".equals(l))) {
            throw new WyjatekException("niepoprawna liczba graczy");
        }
    }
}
