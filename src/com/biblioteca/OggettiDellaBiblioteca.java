package com.biblioteca;

public class OggettiDellaBiblioteca {

    private String titolo;
    private String autore;
    private String anno;
    private TipoOggetti tipo;

    public OggettiDellaBiblioteca(String titolo, String autore, String anno, TipoOggetti tipo) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.tipo = tipo;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getAnno() {
        return anno;
    }

    public TipoOggetti getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OggettiDellaBiblioteca ogg = (OggettiDellaBiblioteca) obj;
        return this.getTitolo().equalsIgnoreCase(ogg.getTitolo()) && this.getAnno().equalsIgnoreCase(ogg.getAnno())
                && this.getAutore().equalsIgnoreCase(ogg.getAutore()) &&
                this.getTipo() == ogg.getTipo();
    }
}
