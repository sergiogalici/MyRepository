package com.biblioteca;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utenti {

    private String NomeUtente;
    private String password;
    private int ID;
    private Map<OggettiDellaBiblioteca, Long> scadenze = new HashMap<>();
    private Map<OggettiDellaBiblioteca, String> zainoUtente = new HashMap<>();
    private Amministratore amministratore = Amministratore.getInstance();
    private static int IDCount = 1001;
    private boolean moroso = false;

    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }

    public Utenti(String nomeUtente, String password) {
        NomeUtente = nomeUtente;
        this.password = password;
        IDCount++;
        this.ID = IDCount;

    }

    public String getNomeUtente() {
        return NomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public Map<OggettiDellaBiblioteca, Long> getScadenze() {
        return scadenze;
    }

    public boolean isMoroso() {
        return moroso;
    }

    public Map<OggettiDellaBiblioteca, String> getZainoUtente() {
        return zainoUtente;
    }

    public void prendiInPrestito(String nomeOpera, Utenti utente) {
        /*for(OggettiDellaBiblioteca ogg : utente.getScadenze().keySet()) {
            if(utente.getScadenze().get(ogg) + 30 * 1000 < System.currentTimeMillis()) {
                System.out.println("Non hai restituito "+ogg.getTitolo()+" alla biblioteca, quindi da adesso sei\n" +
                        "moroso. Non potrai più prendere in prestito articoli dalla biblioteca.");
                utente.setMoroso(true);
            }
        }*/

        if(!utente.isMoroso()) {
            boolean flag = false;
            for(int i=0; i<amministratore.getArchivio().size(); i++) {
                if(amministratore.getArchivio().get(i).getTitolo().equalsIgnoreCase(nomeOpera)) {
                    System.out.println();

                    System.out.println("Hai preso in prestito "+nomeOpera+".\n" +
                            "Hai un totale di 30 secondi per riportarlo alla biblioteca. \n" +
                            "Se non lo restituirai in tempo, diventerai moroso e non potrai più prendere in prestito" +
                            " altri articoli.");
                    Date date = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    String strDate = dateFormat.format(date);
                    utente.getZainoUtente().put(amministratore.getArchivio().get(i), strDate);
                    utente.getScadenze().put(amministratore.getArchivio().get(i), System.currentTimeMillis());
                    amministratore.getArchivio().remove(amministratore.getArchivio().get(i));
                    flag = true;

                }
            }
            if(!flag) {
                System.out.println();
                System.out.println("Non siamo riusciti a trovare "+nomeOpera+" all'interno " +
                        "dell'archivio della biblioteca");
            }
        } else {
            System.out.println("Sei moroso, per cui non potrai più prendere in prestito alcun articolo dalla " +
                    "biblitoeca");
        }


    }
}
