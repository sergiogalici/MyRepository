package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Amministratore extends Utenti  {


    private List<Utenti> listaUtenti = new ArrayList<>();
    private List<OggettiDellaBiblioteca> archivio = new ArrayList<>();
    private static Amministratore instance = new Amministratore("Admin", "1234");

    private Amministratore(String nomeUtente, String password) {
        super(nomeUtente, password);
        //this.listaUtenti.add(new Utenti("Marco", "1234"));
        //this.listaUtenti.add(new Utenti("Giulia", "1234"));
        //this.listaUtenti.add(new Utenti("Francesca", "1234"));
        archivio.add(new Libri("Diario di Anna Frank", "Anna Frank",
                "1947"));
        archivio.add(new Libri("Full Metal Jacket", "Stanley Kubrick",
                "1987"));
        archivio.add(new Dischi("Black Sabbath", "Black Sabbath", "1970"));
    }

    public static Amministratore getInstance() {
        return instance;
    }

    public List<Utenti> getListaUtenti() {
        return listaUtenti;
    }

    public List<OggettiDellaBiblioteca> getArchivio() {
        return archivio;
    }

    public void inserisciOggettoInArchivio(OggettiDellaBiblioteca ogg) {
        boolean flag = false;
        for(int i = 0; i<archivio.size(); i++) {
            if(archivio.get(i).equals(ogg)) {
                System.out.println(ogg.getTitolo()+" era già presente nell'archivio della biblioteca.\n" +
                        "Impossibile aggiungere.");
                flag = true;
            }
        }
        if(!flag) {
            archivio.add(ogg);
            System.out.println(ogg.getTitolo()+" dell'autore "+ogg.getAutore()+" dell'anno "+ogg.getAnno()+"" +
                    " è stato inserito all'interno dell'archivio della biblioteca");
        }

    }

    public void rimuoviOggettoDallArachivio(int indice) {
        System.out.println(archivio.get(indice - 1).getTitolo()+" dell'autore "+archivio.get(indice - 1).getAutore()+
                " dell'anno "
                +archivio.get(indice - 1).getAnno()+"" +
                " è stato rimosso dall'archivio della biblioteca");
        archivio.remove((indice - 1));

    }

    public void stampListaArchivio() {
        System.out.println("=======LISTA ARCHIVIO BIBLIOTECA=======");
        for(int i=0; i<archivio.size(); i++) {
            System.out.println((i+1)+" Titolo: "+archivio.get(i).getTitolo()+", anno: "+archivio.get(i).getAnno()+
                    " autore: "+archivio.get(i).getAutore()+" - "+archivio.get(i).getTipo());
        }
    }

    public void stampaListaUtenti() {
        System.out.println("=======LISTA UTENTI BIBLIOTECA=======");
        for(int i=0; i<listaUtenti.size(); i++) {
            System.out.println("Nome utente: "+listaUtenti.get(i).getNomeUtente()+", ID: "+listaUtenti.get(i).getID());

            for(OggettiDellaBiblioteca ogg : listaUtenti.get(i).getZainoUtente().keySet()) {
                System.out.println("Articoli posseduti dall'utente: ");
                if(ogg != null) {
                    System.out.println(ogg.getTitolo());
                    System.out.println("Data in cui l'utente ha preso in prestito l'articolo: ");
                    System.out.println(listaUtenti.get(i).getZainoUtente().get(ogg));
                }
            }
            /*for(OggettiDellaBiblioteca ogg : listaUtenti.get(i).getScadenze().keySet()) {
                if(listaUtenti.get(i).getScadenze().get(ogg) + 30 * 1000 < System.currentTimeMillis()) {
                    listaUtenti.get(i).setMoroso(true);
                }
            }*/
            if(listaUtenti.get(i).isMoroso()) {
                System.out.println("L'utente è moroso.");
                System.out.println();
            } else {
                System.out.println("L'utente non è moroso");
                System.out.println();

            }
            System.out.println("==========");

        }
    }

    public void aggiungiUtente(String nomeUtente) {
        boolean flag = false;
        for(int i=0; i<listaUtenti.size(); i++) {
            if(listaUtenti.get(i).getNomeUtente().equalsIgnoreCase(nomeUtente)) {
                System.out.println("L'utente "+listaUtenti.get(i).getNomeUtente()+" è già presente nel sistema.");
                flag = true;
            }
        }
        if(!flag) {
            listaUtenti.add(new Utenti(nomeUtente, InserisciPassword.inserisciPassword()));
            System.out.println(nomeUtente+" è stato inserito nel sistema");
        }
    }

    /**
     * @Depracted
     * @param nomeUtente
     * @return
     */
    public boolean utentePresente(String nomeUtente) {
        for(int i=0; i<listaUtenti.size(); i++) {
            if(listaUtenti.get(i).getNomeUtente().equalsIgnoreCase(nomeUtente)) {
                return true;
            }
        }
        return false;
    }
 }
