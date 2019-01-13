package tp4;

import javafx.scene.control.Button;
public class Walidacja {

    

    public Walidacja (int a, int b, int liczba_graczy, Button wszystkie[])
    {//w arguumentach trzeba dodac jeszcze klienta
        // 1) warunek ze pierwszy pion musi byc koloru tego klienta
        /*
        dostajemy inty ktore sa napisami na pionach ktorymi klient chce wykonac ruch,
         */
        for(int i=0;i<221;i++)
        {
            Button p1 = new Button();
            Button p2 = new Button();
            String s = (wszystkie[i].getText());
            if((Integer.parseInt(wszystkie[i].getText()))==a)
                p1=wszystkie[i];

            if(Integer.parseInt(wszystkie[i].getText()) ==b)
                p2=wszystkie[i];
        }

       // if()
    }
    public int  zwroc_boollean () {
        int b = 1;
        return b;
    }
}
