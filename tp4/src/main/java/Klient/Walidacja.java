package Klient;

import javafx.scene.control.Button;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


// TEGO NIE RUSZALEM
public class Walidacja {

    Button p1 = new Button();
    Button p2 = new Button();
    Button pomiedzy1 = new Button();
    Button pomiedzy2 = new Button();

    private double x_1, x_2, y_1, y_2;

    public Walidacja (int a, int b, int liczba_graczy, Button wszystkie[]) {
        for(int i=0;i<221;i++) //szukanie przyciskow p1,p2
        {

            // String s = (wszystkie[i].getText());
            if((Integer.parseInt(wszystkie[i].getText()))==a)
                p1=wszystkie[i];

            if(Integer.parseInt(wszystkie[i].getText()) ==b)
                p2=wszystkie[i];
        }
        System.out.println(p1.getText());
        System.out.println(p2.getText());

        x_1 = p1.getLayoutX();
        y_1 = p1.getLayoutY();
        x_2 = p2.getLayoutX();
        y_2 = p2.getLayoutY();

        for(int i=0;i<221;i++)
        {
            if((wszystkie[i].getLayoutX()==((x_1+x_2)/2))&&(wszystkie[i].getLayoutY()==y_1)&&(wszystkie[i].getLayoutY()==y_2)) {
                pomiedzy1=wszystkie[i];
            }
            double srednia_x=(x_1+x_2)/2;
            double srednia_y=(y_1+y_2)/2;
            if((wszystkie[i].getLayoutX()>srednia_x-1)&&(wszystkie[i].getLayoutX()<srednia_x+1)&&(wszystkie[i].getLayoutY()>srednia_y-1)&&(wszystkie[i].getLayoutY()<srednia_y+1)) {
                pomiedzy2=wszystkie[i];
            }
        }       // if()
    }
    public int  zwroc_boollean () {
        String buttonText = p2.getStyle();
        String puste_pole ="-fx-background-radius: 500em; -fx-background-color: SALMON; -fx-text-fill: SALMON; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px;";

        double odl=sqrt(pow((x_1-x_2),2.0)+pow(y_1-y_2,2.0));
        System.out.println(odl);


        if(buttonText!=puste_pole) //jesli drugie klikniete pole nie jest puste to nie mozna wykonac ruchu
        {
            System.out.println("111111111111");
            return 0;


        }
        else if(odl<81.0)//warunek na odleglosc zamienianych przyciskow (podsumowujac jesli odl to 1 i drugie pole jest wolne ruch jest mozliwy)
        {
            System.out.println("222222222");
            return 1;
        }
        else if((odl>119)&&(odl<140))
        {

            if(odl==120.0) // przeskok poziomy
            {
                String co_pomiedzy =pomiedzy1.getStyle();

                if(co_pomiedzy==puste_pole)
                {
                    System.out.println("33333333");
                    return 0;
                }
                else {
                    System.out.println("4444444444");
                    return 1;
                }
            }
            else if((odl>133)&&(odl<135))//przeskok skosny
            {
                String co_pomiedzy =pomiedzy2.getStyle();
                if(co_pomiedzy==puste_pole)
                {
                    System.out.println("55555555");
                    return 0;
                }
                else {
                    System.out.println("666666666");
                    return 1;
                }

            }
            else {
                System.out.println("7777777777");
                return 0;
            }
        }
        else {
            System.out.println("8888888888");
            return 0;
        }
    }
}
