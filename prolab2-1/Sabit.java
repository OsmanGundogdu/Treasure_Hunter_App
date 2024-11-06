package Prolab2_1;

import java.awt.*;
import java.util.Random;

public class Sabit extends Rectangle {
    String name;
    public boolean collected = false;
    private final int[] boyutlar = {3, 4, 5};
    private final int[] boyutlar1 = {2, 3};
    Arayuz arayuz = new Arayuz(1000, 800, 10);
    public Sabit(int a) {

        switch (a)
        {
            case 1:  // Agac
                Random random1 = new Random();
                x = random1.nextInt(arayuz.genislik / arayuz.karoBoyutu - 5);
                y = random1.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 5);
                width = boyutlar[random1.nextInt(3)];
                height = width;

                break;
            case 2:  // Kaya
                Random random2 = new Random();
                x = random2.nextInt(arayuz.genislik / arayuz.karoBoyutu - 3);
                y = random2.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 3);
                width = boyutlar1[random2.nextInt(2)];
                height = width;
                break;
            case 3:  // Dag
                Random random3 = new Random();
                x = random3.nextInt(arayuz.genislik / arayuz.karoBoyutu - 15);
                y = random3.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 15);
                width = 15;
                height = width;
                break;
            case 4:  // Duvar
                Random random4 = new Random();
                x = random4.nextInt(arayuz.genislik / arayuz.karoBoyutu - 10) - 1;
                y = (random4.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 1) - 1);
                width = 12;
                height = 3;
                break;
            case 5: // altin
                Random random5 = new Random();
                x = random5.nextInt(arayuz.genislik / arayuz.karoBoyutu - 2);
                y = random5.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 2);
                width = 2;
                height = 2;
                name="altin";
                break;
            case 6: // gumus
                Random random6 = new Random();
                x = random6.nextInt(arayuz.genislik / arayuz.karoBoyutu - 2);
                y = random6.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 2);
                width = 2;
                height = 2;
                name="gumus";
                break;
            case 7: // zumrut
                Random random7 = new Random();
                x = random7.nextInt(arayuz.genislik / arayuz.karoBoyutu - 2);
                y = random7.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 2);
                width = 2;
                height = 2;
                name="zumrut";
                break;
            case 8: // bakir
                Random random8 = new Random();
                x = random8.nextInt(arayuz.genislik / arayuz.karoBoyutu - 2);
                y = random8.nextInt(arayuz.yukseklik / arayuz.karoBoyutu - 2);
                width = 2;
                height = 2;
                name="bakir";
                break;
        }
    }
}
