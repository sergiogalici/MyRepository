package com.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScelteAmministratore {

    private static Amministratore amministratore = Amministratore.getInstance();

    public static void scelte() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while(!flag) {
            System.out.println("======LISTA DEI COMANDI======");
            System.out.println("Premi 0 per stampare la lista degli utenti.\n" +
                    "Premi 1 per aggiungere un nuovo utente al database. \n" +
                    "Premi 2 per aggiungere un nuovo articolo all'archivio della biblioteca\n" +
                    "Premi 3 per rimuovere un articolo dalla biblioteca \n" +
                    "Premi 4 per stampare la lista degli articoli presenti in archivio\n"+
                    "Premi Q per eseguire il log-out.");
            String scelta = scanner.nextLine();
            switch (scelta) {
                case "0":
                    amministratore.stampaListaUtenti();
                    break;
                case "1":
                    System.out.print("Scegli un nome per l'utente che vuoi aggiungere al database: ");
                    String nomeUtente = scanner.nextLine();
                    amministratore.aggiungiUtente(nomeUtente);
                    break;
                case "2":
                    boolean inserisciOggetto = false;
                    while(!inserisciOggetto) {
                        System.out.println("Che tipo di articolo vuoi inserire nell'archivio? Premi\n" +
                                "1 per film\n" +
                                "2 per disco\n" +
                                "3 per libro");
                        String sceltaOggetto = scanner.nextLine();
                        String titoloOpera;
                        String autoreOpera;
                        String annoOpera;
                        switch (sceltaOggetto) {
                            case "1":
                                System.out.println("Inserire il titolo dell'opera: ");
                                titoloOpera = scanner.nextLine();
                                System.out.println("Inserire l'anno di pubblicazione: ");
                                annoOpera = scanner.nextLine();
                                System.out.println("Inserire l'autore (o gli autori) dell'opera: ");
                                autoreOpera = scanner.nextLine();
                                amministratore.inserisciOggettoInArchivio(
                                        new Film(titoloOpera, autoreOpera, annoOpera));
                                inserisciOggetto = true;
                                break;
                            case "2":
                                System.out.println("Inserire il titolo dell'opera: ");
                                titoloOpera = scanner.nextLine();
                                System.out.println("Inserire l'anno di pubblicazione: ");
                                annoOpera = scanner.nextLine();
                                System.out.println("Inserire l'autore (o gli autori) dell'opera: ");
                                autoreOpera = scanner.nextLine();
                                amministratore.inserisciOggettoInArchivio(
                                        new Dischi(titoloOpera, autoreOpera, annoOpera));
                                inserisciOggetto = true;
                                break;
                            case "3":
                                System.out.println("Inserire il titolo dell'opera: ");
                                titoloOpera = scanner.nextLine();
                                System.out.println("Inserire l'anno di pubblicazione: ");
                                annoOpera = scanner.nextLine();
                                System.out.println("Inserire l'autore (o gli autori) dell'opera: ");
                                autoreOpera = scanner.nextLine();
                                amministratore.inserisciOggettoInArchivio(
                                        new Libri(titoloOpera, autoreOpera, annoOpera));
                                inserisciOggetto = true;
                                break;
                            default:
                                System.out.println("Scelta non valida.");
                                break;
                        }
                    }
                    break;
                case "3":
                    amministratore.stampListaArchivio();
                    while(true) {
                        System.out.println("Inserisci l'indice dell'articolo che vuoi eliminare: ");
                        try {
                            int indiceRimuovi = scanner.nextInt();
                            amministratore.rimuoviOggettoDallArachivio(indiceRimuovi);
                        } catch (InputMismatchException e) {
                            System.out.println("Scelta non valida.");
                        } finally {
                            break;
                        }
                    }
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
