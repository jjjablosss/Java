package gui.systmu;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Main {

    public static void main(String args[]) {
        int delay = 0;
        delay = SumaCzasu();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               try {
                    System.out.println("test");
                    Runtime.getRuntime().exec("shutdown -s -t 0");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        },delay);


    }//Koniec klasy głównej MAIN

    public static int Odczytaj(String jednostka){
        int temp = -1;
        boolean koniec = false;

        System.out.print("Podaj czas w "+jednostka+" do wykonania programu : ");
        while(!koniec){
            Scanner wejsciowa = new Scanner(System.in);
            if (wejsciowa.hasNextInt()) {
                temp = wejsciowa.nextInt();
            }
           if(temp >= 0){
                koniec = true;

                switch (jednostka){
                    case "godzinach":
                        return temp * 3600000;

                    case "minutach":
                        return temp * 60000;

                    case "sekundach":
                        return temp * 1000;
                }
            }
            else {
                System.out.print("Podaj poprawna wartosc : ");
            }

        }
        return 0;
    }//Koniec funkcji Odczytaj

    public static int SumaCzasu(){
        String temp = "";
        int delay = 0;
        for(int i=0;i<3;i++) {
            if(i == 0) {
                temp = "godzinach";
                delay = Odczytaj(temp);
            }
            else if(i == 1){
                temp = "minutach";
                delay = delay + Odczytaj(temp);
            }
            else if(i == 2){
                temp = "sekundach";
                delay = delay + Odczytaj(temp);
            }
        }//Koniec petli for
        return delay;
    }
}//Koniec głównej klasy
