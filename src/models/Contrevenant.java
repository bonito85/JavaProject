package models;

import Exceptions.InvalidInputException;
import Interfaces.Personne;

//import static jdk.internal.net.http.common.Utils.isValidName;

public class Contrevenant implements Personne {
    private int id;
    private String nom;
    private String adresse;
    private String numeroPermis;

    // Constructeur de la classe Contrevenant

    public Contrevenant(String nom, String adresse, String numeroPermis) throws InvalidInputException {
        setNom(nom);
        this.adresse = adresse;
        this.numeroPermis = numeroPermis;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) throws InvalidInputException {
        if (!isValidName(nom)) {
            throw new InvalidInputException("Le nom ne doit contenir que des lettres :)");
        }
        this.nom = nom;
    }

    @Override
    public String getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

}
