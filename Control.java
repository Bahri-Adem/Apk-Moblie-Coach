package com.example.hadoula.controler;
import com.example.hadoula.Model.Profil;
public final class Control {
    private static Control instance = null;
    private Profil profil;

    private Control() {
        super();
    }

    public static final Control getInstance() {
        if (Control.instance == null) {
            Control.instance = new Control();
        }
        return Control.instance;
    }

    public void creerProfil(Integer poids, Integer taille, Integer
            age, Integer sexe) {
        profil = new Profil(poids, taille, age, sexe);
    }

    public float getImg() {
        return profil.getImg();
    }

    public String getMessage() {
        return profil.getMessage();
    }
}