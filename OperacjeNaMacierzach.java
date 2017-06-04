import javafx.scene.control.Tab;

import java.util.Scanner;

/**
 * Created by Hubert on 03.06.2017.
 */
public class main {
    public static void main(String args[]){
        System.out.print("Podaj wysokosc macierzy : ");
        int height = OdczytajLiczbe();

        System.out.print("Podaj szerokosc macierzy : ");
        int  width= OdczytajLiczbe();

        int [][] TablicaMacierzy = new int [height][width];
        WypelnijMacierz(height, width, TablicaMacierzy);

        SumujPrzekatne(height, width, TablicaMacierzy);
    }//Koniec petli main

   static void WypelnijMacierz(int height ,int width, int [][] TablicaMacierzy){
        int temp1 = 0, temp2 = 0, WpisywanaWartosc = 0;
        while (temp1 != width && temp2 != height) {
            for (temp1 = 0; temp1 < width; temp1++) {
                System.out.println("Podaj wartosc do wpisania");
                WpisywanaWartosc = OdczytajLiczbe();
                System.out.println("Height : "+height);
                System.out.println("Width : "+width);
                System.out.println("Tablica[ "+temp2+" ],[ "+temp1+" ]");
                TablicaMacierzy[temp2][temp1] = WpisywanaWartosc;
                System.out.println("Wartosc tablicy w punkcie [ y : "+ temp2 +" ],[ x:  "+ temp1+ " ] wynosi : "+ TablicaMacierzy[temp2][temp1]);
            }//Koniec petli for wew.
            temp1 = 0;
            if(temp2<height)
                temp2++;
            else
                break;
        }//Koniec petli while
       WyswietlMacierz(height, width, TablicaMacierzy);
    }//Koniec funkcji UtworzMacierz

   static int OdczytajLiczbe(){
        int temporary1=0;
        Scanner temporary = new Scanner(System.in);
        do{
        if(temporary.hasNextInt()){
            temporary1 = temporary.nextInt();
            if(temporary1> 0)
                return temporary1;
        }
        else
            System.out.println("Podano bledna wartosc");
        }while(temporary1<0);

        return 0;
    }//Koniec funkcji odczytaj liczbe


    static void WyswietlMacierz(int height, int width, int[][] TablicaMacierzy){
       int temp1=0, temp2=0;
        System.out.println("Zostala wprowadzona macierz o wysokosci ("+height+"), o szerokosci ("+ width +"), jej wartosci to :");
       while(temp1 < width && temp2 < height) {
           for (temp1 = 0; temp1 < width; temp1++){
               System.out.print(TablicaMacierzy[temp2][temp1]+" ");
           }//Koniec petli for
           temp1 = 0;
           if(temp2<height) {
               temp2++;
               System.out.println("");
           }
           else {
               break;
           }
       }//Koniec petli while
    }//Koniec funkcji WyswietlMacierz

    static int SumujPrzekatne(int height, int width, int [][] TablicaMacierzy){
       int x = 0,y = 0,suma_pierwszej = 0, suma_drugiej = 0, suma = 0;
       RysujKreski(width);
       while(x < width && y < height) {
           for (x = 0, y = 0; y < height ; x++,y++) {
               suma_pierwszej = suma_pierwszej + TablicaMacierzy[y][x];
               suma_drugiej = suma_drugiej + TablicaMacierzy[y][((width - 1) - x)];
           }//Koniec wew. petli for
           x = 0;
           if(y<height)
               y ++;
           else
               suma = suma + suma_pierwszej + suma_drugiej;
           System.out.println("Suma pierwszej przekatnej wynosi : (" + suma_pierwszej + "), suma drugiej przekatnej wynosi : ("+ suma_drugiej + ") a suma obu wynosi ("+ suma +")");
           }//Koniec petli while
        return 0;
    } //Koniec funkcji SumujPrzekatne

    static void RysujKreski(int width){
        for(int i = 0; i <= width; i++){
            System.out.print("-");
        }
        System.out.println("");
    }//Koniec klasy rysuj kreske
}//Koniec glownej klasy
