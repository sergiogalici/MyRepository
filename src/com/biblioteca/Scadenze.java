package com.biblioteca;

public class Scadenze extends Thread {
    private Amministratore amministratore = Amministratore.getInstance();

    @Override
    public void run() {
        while(true) {
            for(int i = 0; i<amministratore.getListaUtenti().size(); i++) {
                Utenti utente = amministratore.getListaUtenti().get(i);
                for(OggettiDellaBiblioteca ogg : utente.getScadenze().keySet()) {
                    if((utente.getScadenze().get(ogg) + 30 * 1000) < System.currentTimeMillis()) {
                        utente.setMoroso(true);
                    }
                }
            }
        }
    }


}
