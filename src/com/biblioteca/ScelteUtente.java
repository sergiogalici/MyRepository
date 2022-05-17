package com.biblioteca;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ScelteUtente {

    private static Amministratore amministratore = Amministratore.getInstance();

    public static void scelte(Utenti utente) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while(!flag) {
            for(OggettiDellaBiblioteca ogg : utente.getScadenze().keySet()) {
                /*if(utente.getScadenze().get(ogg) + 30 * 1000 < System.currentTimeMillis()) {
                    System.out.println();

                    System.out.println("======ATTENZIONE======");
                    System.out.println("Non hai restituito "+ogg.getTitolo()+" alla biblioteca, quindi da adesso sei\n" +
                            "moroso. Non potrai più prendere in prestito articoli dalla biblioteca.");
                    System.out.println("==========");
                    utente.setMoroso(true);
                }*/
            }
            System.out.println();
            System.out.println("======LISTA DEI COMANDI======");
            System.out.println("Premi 0 per stampare la lista degli articoli in archivio.\n" +
                    "Premi 1 per prendere in prestito un articolo dall'archivio.\n" +
                    "Premi 2 per restituire un articolo alla biblioteca.\n" +
                    "Premi Q per eseguire il log-out.");
            String scelta = scanner.nextLine();
            switch (scelta) {
                case "0":
                    amministratore.stampListaArchivio();
                    break;
                case "1":
                    System.out.print("Inserisci il titolo dell'opera che vuoi prendere in prestito: ");
                    String nomeOpera = scanner.nextLine();
                    utente.prendiInPrestito(nomeOpera, utente);
                    break;
                case "Q": case "q": case "quit": case "qq": case "QQ":
                    flag = true;
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
        Main.startProgram();
    }
}
