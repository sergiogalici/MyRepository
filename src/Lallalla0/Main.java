package Lallalla0;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.print("Inserisci la cifra da analizzare: ");
            isPalindrome(scanner.nextInt());

        }
    }

    public static void isPalindrome(int myNumber) {
        int reversedNumber = 0, lastDigit;
        int copiedNumber = myNumber;


        while(copiedNumber != 0) {
            lastDigit = copiedNumber % 10;
            System.out.println("last digit "+lastDigit);
            reversedNumber +=lastDigit;
            System.out.println("reversed number = "+reversedNumber);

            reversedNumber *= 10;
            System.out.println("reversed number*10 = "+reversedNumber);

            copiedNumber /= 10;
            System.out.println("copied number = "+copiedNumber);

        }
        reversedNumber /= 10;
        if(reversedNumber == myNumber) {
            System.out.println("Il numero è palindromo");
        } else {
            System.out.println("suca");
        }


    }
}
