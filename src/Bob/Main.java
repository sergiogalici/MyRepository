package Bob;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.print("Say something to Bob: ");
            String s = scanner.nextLine();

            char[] myArr = {'A', 'B', 'D', 'E', 'C'};

            // check to see if it's all uppercase

            boolean allCapital = false;
            String copiedString = s.toLowerCase();
            if(s.equals(copiedString.toUpperCase())) {
                allCapital = true;
            }

            if(s.toUpperCase().contains("BOB")) {
                System.out.println("Bob says: \"Fine! Be that way\"");
            } else if(s.contains("?") && !allCapital) {
                System.out.println("Bob says: \"Sure bro\"");
            } else if(!s.contains("?") && allCapital) {
                System.out.println("Bob says: \"woah, chill out bruh\"");
            } else if (s.contains("?") && allCapital) {
                System.out.println("Bob says: \"Calm down! I know what I'm doing!\"");
            } else {
                System.out.println("Bob says: \"Yeah, whatever\"");
            }


        }

    }
}
