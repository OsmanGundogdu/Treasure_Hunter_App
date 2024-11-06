package Prolab2_1;

import java.awt.*;
import java.util.Random;

public class Dinamik extends Rectangle{

    public Dinamik(int a) {
        switch (a) {
            case 1:  // Ari sag sol 3 kare
                Random random1 = new Random();
                x = random1.nextInt(95);
                y = random1.nextInt(75);
                width = 2;
                height = 2;
                break;
            case 2:  // Kus yukari asagi 5 kare
                Random random2 = new Random();
                x = random2.nextInt(97);
                y = random2.nextInt(77);
                width = 2;
                height = 2;
                break;
        }
    }



}
