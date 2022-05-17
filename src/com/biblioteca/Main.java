package com.biblioteca;

public class Main {

    private static Amministratore amministratore = Amministratore.getInstance();

    public static void main(String[] args) {


        amministratore.getListaUtenti().add(amministratore);

        Scadenze scadenze = new Scadenze();
        scadenze.start();
        startProgram();
    }

    public static void startProgram() {
        BevenutoUtente.BevenutoUtente(LogIn.logIn());

    }


}
