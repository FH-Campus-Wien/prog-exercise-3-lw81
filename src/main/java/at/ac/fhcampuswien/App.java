package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int days, int start){
        //System.out.println(days);
        //System.out.println(start);
        //Die beiden variablen müssen nicht mehr deklariert werden
        // eine for-schleife mit if und modulo%7
        //jede zahl einen platzbedarf von 2, mit printf %2 immer zweistellig, lehrzeichen geht auch
        //int saveDays = days;
        for (int i = 1; i < days+start; i++){
            int d = (i-start)+1;
            if (d>0){
                //System.out.printf("%3d", d);
                if (d<=9) {
                    System.out.print(" " + d + " ");
                }else {System.out.print(d+ " ");}
            } else{System.out.print("   ");}
            if (i%7 == 0 && i != days+start-1){
                System.out.println();
            }
        }
        System.out.println();

    }
    //aufgabe2
    //array: zB eine liste von zahlen, müssen den gleichen datentyp haben
    // int [] numbers = {1,2,3,4,5}; array ist befüllt
    // int []numbers2 = new int [10]; array noch leer, kan mit scanner befüllt werden
    //numbers2[0] = 6;
    //numbers2[1] = 4;
    //numbers2[9] = 9; 9 ist der hpchste wert von numbers2, immer n-1, weil index start immer bei 0
    //for(int i=0; i < numbers2.length; i++){ statt number2.length ginge auch 10, die andere variante ist aber sicherer
    //System.out.println(numbers2[i]);
    //}
    //methode die nicht void ist, braucht mindestens 1 return statement, methodenabbruch immer mit return;
    // array ist begrenzt, weil fixe größe

    //aufgabe 3, aufrufe in main methode, für alle programme zu machen
    //kein rückgabewert weil void
    // in api von java nachschauen

    //aufgabe 4
    // keine api klassen
    // eine schleife, eine hilfsvariable, arrays tauschen

    //aufgabe 5
    //per hand machen, keine api, viel rechnen mit cen characters
    //als letztes machen
    //lehrzeichen entfernen, char-array

    //aufgabe6
    //kochrezept in 5 zeilen
    //berechnung der prüfziffer aufgrund des arrays


    public static long[] lcg(long seed) {
        long[] randomNumbers = new long[10];
        double m = Math.pow(2, 31); //Modul
        final long MNeu = (long) m;
        final int A = 1103515245; //faktor
        final int C = 12345; //inkrement
        for (int i = 0; i < randomNumbers.length; i++) {
            //long newStart = seed;
            seed = (seed * A + C) % MNeu;
            randomNumbers[i] = seed;

            //System.out.println("w");
        }
        return randomNumbers;
        //null weil noch kein array
        //seed ist x0
        //keine prints, test überprüft ob werte korrekt sind
    }

    public static void guessingGame(int numberToGuess) {
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        int newNumber = 1;
        do {
            counter++;
            newNumber = scanner.nextInt();
            if (counter >= 10) {
                System.out.print("Guess number " + counter + ": ");
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            System.out.print("Guess number " + counter + ": ");
            if (newNumber == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (newNumber > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else {
                System.out.println("The number AI picked is higher than your guess.");
            }
        } while (newNumber >= 1 && newNumber <= 100);
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random r = new Random();
        int number = r.nextInt(100) + 1;
        return number;
    }

    public static boolean swapArrays(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }else{
        int[] arrayThree = new int [arrayOne.length];
        for (int i = 0; i < arrayOne.length; i++) {
            arrayThree[i] = arrayOne[i];
            arrayOne[i] = arrayTwo[i];
            arrayTwo[i] = arrayThree[i];
        }
        return true;
        }
    }

    public static int checkDigit(int[] arrayCheckDigit) {
        int sum = 0;
        for (int i = 0; i < arrayCheckDigit.length; i++) {
            arrayCheckDigit[i] = arrayCheckDigit[i]*(i+2);
            sum = sum + arrayCheckDigit[i];
        }
        int remainder = sum%11;
        int checksum = 11 -remainder;

        if (checksum == 10){
            checksum = 0;
        }else if (checksum == 11){
            checksum = 5;
        }
        System.out.println(checksum);
        return checksum;
    }

    public static String camelCase(String toCamelCaseString) {
        char[] charArrayNew = toCharArray(toCamelCaseString);
        int arrayLength = charArrayNew.length;
        int spaceCount = 0;
        int diff = 'a' - 'A';
        if (charArrayNew[0] > 'Z') {
            charArrayNew[0] -= diff;
        }
        for (int i = 0; i < arrayLength; i++) {
            if (charArrayNew[i] < '0') {            //alle zeichen kleiner 0 in Ascii Tabelle (zb leerzeichen, ?, ',) werden abgezählt
                spaceCount++;
            }
            if (i > 0 && charArrayNew[i] >= 'A' && charArrayNew[i] <= 'Z') { //alle Großbuchstaben werden zu kleinbuchstaben gemacht.
                charArrayNew[i] += diff;
            }
        }

        char[] charArrayCleaned = new char[arrayLength - spaceCount]; //neues cleaned array mit der alten array länge ohne leerzeichen stellen
        int newCnt = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (charArrayNew[i] == ' ' && charArrayNew[i + 1] >= 'a' && charArrayNew[i + 1] <= 'z') {    //kleinbuchstaben nach leerzeichen werden großbuchstaben
                charArrayNew[i + 1] -= diff;
            }
            if (!(charArrayNew[i] < '0')) {           //solange es kein  zeichen der ascii tabelle kleiner 0 ist, wird es ins neue cleaned array kopiert. alle leerzeichen und sonderzeichen weg.
                charArrayCleaned[newCnt] = charArrayNew[i];
                newCnt++;
            }
        }

        StringBuilder String = new StringBuilder(java.lang.String.valueOf(charArrayCleaned, 0, charArrayCleaned.length));
        toCamelCaseString = String.toString();

        return toCamelCaseString;
    }

    public static char[] toCharArray(String stringToChar) {
        char[] charArray = new char[stringToChar.length()];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = stringToChar.charAt(i);
        }
        return charArray;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = scan.nextInt();
        int start = scan.nextInt();
        oneMonthCalendar(days, start);

        long[] randomNumbers = lcg(0);

        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println("Number " + (i + 1) + ": " + randomNumbers[i]);
        }

        int numberToGuess = randomNumberBetweenOneAndHundred();
        //System.out.println("Nummer ist: " + numberToGuess); //Vor Abgabe noch löschen...
        guessingGame(numberToGuess);

        int[] arrayOne = {1, 2, 3, 4, 5};
        int[] arrayTwo = {100, 99, 60, 44, 2};
        swapArrays(arrayOne, arrayTwo);

        System.out.println("Laenge des Array eingeben ");
        int arrayLength = scan.nextInt();
        int[] arrayCheckDigit = new int[arrayLength];
        for (int j = 0; j < arrayCheckDigit.length; j++) {
            System.out.println("Bitte einstellige Zahl" + (j + 1) + "eingeben ");
            arrayCheckDigit[j] = scan.nextInt();
            if (arrayCheckDigit[j] >= 10 && arrayCheckDigit[j] < 0){
                break;
            }
        }

        checkDigit(arrayCheckDigit);

        Scanner scanner = new Scanner(System.in);
        String toCamelCaseString = scanner.nextLine();
        camelCase(toCamelCaseString);

        //void methode braucht immer einen aufruf, eine methode kann immer nur  1 Wert zurückliefern, es kommt immer eine zahl zurück,
        //lcg hat returnwert, wo steht der methodenaufruf? teil einer zuweisung


    }
}
