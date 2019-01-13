package tp4;

import javafx.scene.control.Button;
public class Walidacja {

    Button p1 = new Button();
    Button p2 = new Button();

    public Walidacja (int a, int b, int liczba_graczy, Button wszystkie[])
    {//w arguumentach trzeba dodac jeszcze klienta
        //Gwiazda gw = new Gwiazda(liczba_graczy);
        // 1) warunek ze pierwszy pion musi byc koloru tego klienta
        /*
        dostajemy inty ktore sa napisami na pionach ktorymi klient chce wykonac ruch,
         */
        for(int i=0;i<221;i++)
        {

           // String s = (wszystkie[i].getText());
            if((Integer.parseInt(wszystkie[i].getText()))==a)
                p1=wszystkie[i];

            if(Integer.parseInt(wszystkie[i].getText()) ==b)
                p2=wszystkie[i];
        }
        System.out.println(p1.getText());
        System.out.println(p2.getText());

       // if()
    }
    public int  zwroc_boollean () {
        String buttonText = p2.getStyle();
        String puste_pole ="-fx-background-radius: 500em; -fx-background-color: SALMON; -fx-text-fill: SALMON; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";
        if(buttonText!=puste_pole) //jesli drugie klikniete pole nie jest puste to nie mozna wykonac ruchu
        {
            return 0;
        }
        else {
            int b = 1;
            return b;
        }
    }
}
