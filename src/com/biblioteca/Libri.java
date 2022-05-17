package com.biblioteca;

public class Libri extends OggettiDellaBiblioteca{

    public Libri(String titolo, String autore, String anno) {
        super(titolo, autore, anno, TipoOggetti.LIBRO);
    }

}
