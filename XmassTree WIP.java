import org.apache.xmlbeans.xml.stream.Space;
import sun.awt.Symbol;

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
            default :
                System.out.print("Podany kierunek jest niepoprawny.");
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
        char Znak;
        String StringZnak;
        System.out.print("Podaj pojedynczy znak (np.*)  : ");
        Scanner scanCharacter = new Scanner(System.in);
        if(scanCharacter.hasNext()) {
            StringZnak = scanCharacter.nextLine();
            Znak = StringZnak.charAt(0);

            return Znak;
        }//Koniec Petli if
        else{
            System.out.print("Podaj poprawny pojedyczny znak np.'*' ");
        }//Koniec Else
        return '*';
    }//Koniec klasy getCharacter;

    public enum DirectionBase { //Definiowanie prawidlowych odpowiedzi do getDirection()
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
            for(DirectionBase dir : DirectionBase.values()){
                Tempname = dir.name();
                if(Tempname.equals(kierunek)) {
                    return kierunek;
                }//Koniec petli if
            }//Koniec Petli For
            System.out.print("Podaj kierunek w którym ma być narysowana choinka (UP,DOWN,RIGHT,LEFT) : ");
        }//Koniec petli for
    }//Koniec klasy getDirection

    public static void XmassTreeUp(int Height, char Character) {
        for(int i= 0;i< Height; i++){
            drawCharacterUpDown(Height -i - 1, ' ');
            drawCharacterUpDown(2 * i + 1, Character);

            System.out.println();

        }//Koniec petli for
    }//Koniec XmassTreeUp

    public static void XmassTreeDown(int Height, char Character) {
        for(int i=0 ;i < Height ;i++) {
            drawCharacterUpDown(1*i,' ');
            drawCharacterUpDown(2* Height - 2*i - 1, Character);
            System.out.println("");
        }//Koniec petli for
    }//Koniec XmassTreeDown

    public static void XmassTreeRight(int Height, char Character) {
        drawCharacaterRightUp(Height, Character);
        drawCharacterLeftRightMed(Height, Character);
        drawCharacterRightDown(Height, Character);

    }//Koniec XmassTreeRight

    public static void XmassTreeLeft(int Height, char Character) {
        drawCharacterLeftUp(Height, Character);
        drawCharacterLeftRightMed(Height, Character);
        drawCharacterLeftDown(Height, Character);

    }//Koniec XmassTreeLeft

    public static void drawCharacterUpDown(int Height, char Character){
        for (int i = 0; i< Height; i++){
            System.out.print(Character);
        }//Koniec petli for;

    }//Koniec funkcji drawCharacter

    public static void drawCharacaterRightUp(int Height, char Character){

        for(int FreeSpaceInt  = Height - 1; FreeSpaceInt > 0; FreeSpaceInt--) {
            for(int CharacterInt = Height - FreeSpaceInt; CharacterInt > 0; CharacterInt--){

                System.out.print(Character);

            }//Koniec petli for wew.
            for(int SpaceInt = 0; SpaceInt < FreeSpaceInt; SpaceInt++) {

                System.out.print(" ");

            }//Koniec petli for wew.

            System.out.println("");

        }//Koniec Petli for zew.
    }//Koniec klasy drawCharacterRightUp

    public static void drawCharacterLeftUp(int Height, char Character)
    {
        for(int SymbolInt = 0; SymbolInt < Height - 1; SymbolInt++){
            for(int SpaceInt = 0;SpaceInt < Height - SymbolInt - 1; SpaceInt++){

                System.out.print(" ");

            }//Koneic petli for wew.

            for(int CharacterInt = 0; CharacterInt <= SymbolInt; CharacterInt++){

                System.out.print(Character);

            }//Koniec petli for wew.
            System.out.println("");
        }//Koniec petli for zew.
    }//Koniec klasy drawCharacterLeftUp

   // public static void drawCharacterUp(boolean side, int Height, char Character)


    public static void drawCharacterRightDown(int Height, char Character){
        for(int FreeSpace = 0; FreeSpace < Height - 1; FreeSpace++){
            for(int CharacterInt = 0; CharacterInt < Height -FreeSpace -1; CharacterInt ++){

                System.out.print(Character);

            }//Koniec petli for wew.
            for(int SpaceInt = 0; SpaceInt < FreeSpace;SpaceInt++) {

                System.out.print(" ");

            }//Koniec prtli wew.
            System.out.println("");

        }//Koniec petli for zew.
    }//Koniec klasy drawCharacterRightMed

    public static void drawCharacterLeftDown(int Height, char Character)
    {
        for(int SymbolInt = Height -1; SymbolInt  > 0; SymbolInt--){
            for(int LineInt = Height - SymbolInt; LineInt > 0; LineInt--){

                System.out.print(" ");

            }//Koniec petli for wew.

            for(int SpaceInt = 0; SpaceInt < SymbolInt; SpaceInt++) {

                System.out.print(Character);

            }//Koniec Petli for wew.

            System.out.println("");

        }//Koniec petli for zew.
    }//Koniec klasy drawCharacterLeftDown

    public static void drawCharacterLeftRightMed(int Height, char Character){
        for(int CharacterInt = 0; CharacterInt < Height; CharacterInt++){

            System.out.print(Character);

        }//Koniec petli for
       System.out.println("");

    }//Koniec klasy drawCharacterLeftMed
}//Koniec Głównej Klasy
