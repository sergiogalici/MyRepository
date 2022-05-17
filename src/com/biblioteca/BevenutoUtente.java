package com.biblioteca;

public class BevenutoUtente {

    private static Amministratore amministratore = Amministratore.getInstance();

    public static void BevenutoUtente(Utenti utente) {
        if(utente.getNomeUtente().equalsIgnoreCase("admin")) {
            System.out.println("Sei l'amministratore.");
            ScelteAmministratore.scelte();
        } else {
            System.out.println("Benvenuto "+utente.getNomeUtente());
            System.out.println();
            ScelteUtente.scelte(utente);
        }

    }
}
