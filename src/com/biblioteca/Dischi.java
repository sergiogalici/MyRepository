package com.biblioteca;

public class Dischi extends OggettiDellaBiblioteca{

    public Dischi(String titolo, String autore, String anno) {
        super(titolo, autore, anno, TipoOggetti.DISCO);
    }

}
