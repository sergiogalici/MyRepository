package com.biblioteca;

import java.util.Scanner;

public class InserisciPassword {

    private static Scanner scanner = new Scanner(System.in);

    public static String inserisciPassword() {
        System.out.println("Inserisci una password: ");
        String password = scanner.nextLine();
        return password;
    }
}
