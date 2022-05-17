package com.biblioteca;

import java.util.List;
import java.util.Scanner;

public class LogIn {

    private static Amministratore amministratore = Amministratore.getInstance();
    private static Scanner scanner = new Scanner(System.in);


    public static Utenti logIn() {
        boolean flag = false;
        String nomeUtente;
        String password;
        while(true) {
            System.out.println();
            System.out.print("Benvenuta/o sulla piattaforma della biblioteca.\n" +
                    "Per favore, inserisci il tuo nome utente: ");
            nomeUtente = scanner.next();
            System.out.println("Adesso inserisci la tua password: ");
            password = scanner.next();
            List<Utenti> listaUtenti = Amministratore.getInstance().getListaUtenti();
            for(int i=0; i<listaUtenti.size(); i++) {
                Utenti ut = listaUtenti.get(i);
                if(nomeUtente.equalsIgnoreCase(ut.getNomeUtente())) {
                    if(password.equalsIgnoreCase(ut.getPassword())) {
                        return listaUtenti.get(i);
                    } else {
                        System.out.println("Password errata.");

                    }
                }
            }
            if(!flag) {
                System.out.println("Ciao "+nomeUtente+", sembra che tu non sia ancora registrato.\n" +
                        "Per favore, crea una password ed effettua nuovamente il log-in.");
                amministratore.aggiungiUtente(nomeUtente);
                flag = true;
            }
        }
    }
}
