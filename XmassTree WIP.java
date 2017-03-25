import org.apache.xmlbeans.xml.stream.Space;
import sun.awt.Symbol;

import java.util.Random;
import java.util.Scanner;

public class coscos {
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
        }

    }//Koniec Main

    public static int getHeight(){
        int Wejsciowa;
        System.out.print("Podaj Wysokosc choinki : ");
        for(;;) {
            Scanner HeightScanner = new Scanner(System.in);
            if(HeightScanner.hasNextInt()){
                //  Wejsciowa.push(HeightScanner.nextInt());
                Wejsciowa = HeightScanner.nextInt();
                return Wejsciowa;
            }//Koniec petli if
            else{
                System.out.print("Podaj poprawna wartosc wysokosci choinki : ");
            }
        }//Koniec Petli For
    }//Koniec klasy getHeight

    public static char getCharacter(){
        char Znak, defaultCharacter;
        String StringZnak;
        System.out.print("Podaj pojedynczy znak (np.*)  : ");
        Scanner scanCharacter = new Scanner(System.in);
        if(scanCharacter.hasNext()) {
            StringZnak = scanCharacter.nextLine();
            Znak = StringZnak.charAt(0);
           if(StringZnak.length() == 1)
            return Znak;
            else
                defaultCharacter = '*';
                System.out.println("Podano nie poprawny znak, uzywanie znaku domyslnego : '" + defaultCharacter + "'");
        }//Koniec Petli if
        else{
            System.out.print("Podaj poprawny pojedyczny znak np.'*' : ");
        }//Koniec Else
        return '*';
    }//Koniec klasy getCharacter;

    public enum DirectionDatabase { //Definiowanie prawidlowych odpowiedzi do getDirection()
        UP, DOWN, LEFT, RIGHT;
    }

    public static String getDirection(){
        String kierunek;
        String Tempname;
        System.out.print("Podaj kierunek w którym ma być narysowana choinka (UP,DOWN,RIGHT,LEFT) : ");
        for(;;) {
            Scanner DirectionScanner = new Scanner(System.in);
            kierunek = DirectionScanner.next();
            kierunek = kierunek.toUpperCase();
            for(DirectionDatabase dir : DirectionDatabase.values()){
                Tempname = dir.name();
                if(Tempname.equals(kierunek)) {
                    return kierunek;
                }//Koniec petli if
            }//Koniec Petli For
            return kierunek;
           // System.out.print("Podaj kierunek w którym ma być narysowana choinka (UP,DOWN,RIGHT,LEFT) : ");
        }//Koniec petli for
    }//Koniec klasy getDirection

    public static void XmassTreeUp(int Height, char Character) {
        for(int i= 0;i< Height; i++){
            drawCharacter(true,Height -i - 1, ' ', false);
            drawCharacter(true,2 * i + 1, Character, true);

            System.out.println();

        }//Koniec petli for
    }//Koniec XmassTreeUp

    public static void XmassTreeDown(int Height, char Character) {
        for(int i=0 ;i < Height ;i++) {
            drawCharacter(true,1*i,' ', false);
            drawCharacter(true,2* Height - 2*i - 1, Character, false);
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

    public static int RandomBubbles(int min, int max){

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;

    }//Koniec klasy RandomBubbles

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
