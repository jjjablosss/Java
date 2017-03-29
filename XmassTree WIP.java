import sun.awt.Symbol;

import java.util.Random;
import java.util.Scanner;

public class XmassTreeMain {
    public static void main(String[] args)
    {
        String Direction;
        char Character;
        int Height;
        Height = getHeight();
        Character = getCharacter();
        Direction = getDirection();

        switch(Direction)
        {
            case "UP" :
                XmassTreeUp(Height, Character);
                break;

            case "DOWN" :
                XmassTreeDown(Height, Character);
                break;

            case "RIGHT" :
                XmassTreeRight(Height, Character);
                break;

            case "LEFT" :
                XmassTreeLeft(Height, Character);
                break;

            default:
                System.out.print("Wybrano nie poprawny kierunek.");
                break;
        }

    }//Koniec Main

    public static int getHeight(){
        int Wejsciowa = 0;
        boolean test = false;
        System.out.print("Podaj Wysokosc choinki : ");
        do {
            Scanner HeightScanner = new Scanner(System.in);
            if (HeightScanner.hasNextInt()) {
                Wejsciowa = HeightScanner.nextInt();
            }//Koniec petli if
            if (Wejsciowa > 0) {
                test = true;
                return Wejsciowa;
            }//Koniec petli if wew.
            else if (Wejsciowa <= 0)
                System.out.print("Podana wartosc musi byc liczba oraz wieksza od 0: ");
        }while(!test);
        return Wejsciowa;
    }//Koniec klasy getHeight

    public static char getCharacter(){
        char Znak =' ', defaultCharacter;
        String StringZnak = " ";
        boolean test = false;
        do {
            System.out.print("Podaj pojedynczy znak (np.*)  : ");
            Scanner scanCharacter = new Scanner(System.in);
            if (scanCharacter.hasNext()) {
                StringZnak = scanCharacter.nextLine();
                Znak = StringZnak.charAt(0);
            }//Koniec Petli if
            if (StringZnak.length() == 1) {
                test = true;
                return Znak;
            }//koniec if wew.
            else
                System.out.println("Podano znak dluzszy niz jeden znak.");
        }while(!test);//Koniec petli Do
        return Znak;
    }//Koniec klasy getCharacter;


    public static String getDirection(){
        String kierunek;
        String Tempname;
        System.out.print("Podaj kierunek w którym ma być narysowana choinka (UP,DOWN,RIGHT,LEFT) : ");
        for(;;) {

            Scanner DirectionScanner = new Scanner(System.in);
            kierunek = DirectionScanner.next();
            kierunek = kierunek.toUpperCase();

            return kierunek;

        }//Koniec petli for
    }//Koniec klasy getDirection

    public static void XmassTreeUp(int Height, char Character) {

        for(int DrawInt = 0;DrawInt< Height; DrawInt++){
            drawCharacter(true,Height -DrawInt - 1, ' ', false);
            drawCharacter(true,2 * DrawInt + 1, Character, true);

            System.out.println();
        }//Koniec petli for
    }//Koniec XmassTreeUp

    public static void XmassTreeDown(int Height, char Character) {

        for(int DrawInt = 0 ;DrawInt < Height ;DrawInt++) {
            drawCharacter(true,1*DrawInt,' ', false);
            drawCharacter(true,2* Height - 2*DrawInt - 1, Character, false);
            System.out.println("");
        }//Koniec petli for
    }//Koniec XmassTreeDown

    public static void XmassTreeRight(int Height, char Character) {

        drawCharacterRUpLDown(true, Height, Character);
        drawCharacter(false, Height, Character, false);
        drawCharacterLUpRDown(true, Height, Character);

    }//Koniec XmassTreeRight

    public static void XmassTreeLeft(int Height, char Character) {

        drawCharacterLUpRDown(false, Height, Character);
        drawCharacter(false, Height, Character, false);
        drawCharacterRUpLDown(false, Height, Character);

    }//Koniec XmassTreeLeft

    public static int RandomBubbles(int min, int max){
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;

    }//Koniec klasy RandomBubbles

    public static void drawCharacter(boolean ifside ,int Height, char Character,boolean bubbles){
        for (int CharacterInt = 0; CharacterInt < Height; CharacterInt++){
            if(bubbles){
                if(RandomBubbles(1,10) % 4 == 0)
                    System.out.print("o");
                else
                    System.out.print(Character);
            }//Koniec petli if zew.
            else
                System.out.print(Character);
        }//Koniec petli for;
        if(!ifside)
            System.out.println("");
    }//Koniec funkcji drawCharacter

    public static void drawCharacterLUpRDown(boolean side, int Height, char Character){

        for(int SymbolInt = 0; SymbolInt < Height - 1; SymbolInt++){
            for(int SpaceInt = 0;SpaceInt < Height - SymbolInt - 1; SpaceInt++){
                if(!side)
                    System.out.print(" ");
                else
                    System.out.print(Character);

            }//Koneic petli for wew.

            for(int CharacterInt = 0; CharacterInt <= SymbolInt; CharacterInt++){
                if(!side)
                    System.out.print(Character);
                else
                    System.out.print(" ");

            }//Koniec petli for wew.

            System.out.println("");

        }//Koniec petli for zew.
    }//Koniec klasy drawCharacterLUpRDown

    public static void drawCharacterRUpLDown(boolean side, int Height, char Character){

        for(int SymbolInt = Height -1; SymbolInt  > 0; SymbolInt--){
            for(int LineInt = Height - SymbolInt; LineInt > 0; LineInt--){
                if(!side)
                    System.out.print(" ");
                else
                    System.out.print(Character);
            }//Koniec petli for wew.

            for(int SpaceInt = 0; SpaceInt < SymbolInt; SpaceInt++) {
                if(!side)
                    System.out.print(Character);
                else
                    System.out.print(" ");
            }//Koniec Petli for wew.

            System.out.println("");

        }//Koniec petli for zew.
    }//Koniec klasy drawCharacterRUpLDown

}//Koniec Głównej Klasy
